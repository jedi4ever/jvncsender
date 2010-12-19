package com.tightvnc.vncviewer;

/* 
 * Please note:
 * we use the package com.tightvnc.vncviewer because then we don't have to change the visibility
 * of methods or variables
 * */

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import be.jedi.jvncsender.VncMappings;

//http://stackoverflow.com/questions/1248510/convert-string-to-keyevents
//http://stackoverflow.com/questions/664896/get-the-vk-int-from-an-arbitrary-char-in-java

// loadkeys us -> on the server does the trick -> default to US on CDBOOT

//	    Locale locale = Locale.getDefault();
//        System.out.println("Before setting, Locale is = " + locale);
//        // Setting default locale    
//  	  System.out.println(KeyEvent.VK_L);
//  	  
//        locale = new Locale("nl","BE");
//        Locale.setDefault(locale);
//        System.out.println("After setting, Locale is = " + locale);
//
//  	  System.out.println(KeyEvent.VK_L);

//  http://stackoverflow.com/questions/834758/preserving-keyboard-layout-in-a-jtextfield
// http://forums.sun.com/thread.jspa?threadID=762425	
//        InputContext context=InputContext.getInstance();
//        System.out.println(context.getLocale().getCountry());
//        
//        System.out.println(context.selectInputMethod(Locale.ENGLISH));
//        System.out.println(context.getLocale().getDisplayLanguage());

public class VncSenderConnection {

   RfbProto rfb;
   String host = "localhost";
   int port = 5900;
   String passwordParam = "";

   public VncSenderConnection(String host, int port, String password) {
      this.host = host;
      this.port = port;
      this.passwordParam = password;

   }

   public void open() throws Exception {
      this.connectAndAuthenticate();
      System.out.println("sending init string");
      this.sendInit();
   }

   public void close() throws Exception {
      this.sendClose();
   }

   public void println(String sequence) throws Exception {
      this.print(sequence);
      this.print("<RETURN>");
   }

   public void print(String sequence) throws Exception {

      // split for <WAIT> stuff
      // the for each get the sequence
      ArrayList<Integer> keys = VncSenderConnection.stringToKeyCodesList(sequence);

      rfb.eventBufLen = 0;

      boolean shift = false;
      boolean alt = false;
      boolean control = false;
      boolean meta = false;

//      //reset modifiers
//      rfb.writeKeyEvent(0xffe1, false);
//      rfb.writeKeyEvent(0xffe9, false);
//      rfb.writeKeyEvent(0xffe3, false);
//      rfb.writeKeyEvent(0xffe7, false);
      
      Iterator<Integer> KeysIterator = keys.iterator();
      while (KeysIterator.hasNext()) {
         Integer key = KeysIterator.next();
  //        System.out.println(Integer.toHexString(key) +"||");
         System.out.print(".");

         switch (key) {
         case 0xffe1:
            shift = true;
            rfb.writeKeyEvent(key, true);
            break;
         case 0xffe9:
            alt = true;
            rfb.writeKeyEvent(key, true);
            break;
         case 0xffe3:
            control = true;
            rfb.writeKeyEvent(key, true);
            break;
         case 0xffe7:
            meta = true;
            rfb.writeKeyEvent(key, true);
            break;
         default: {

        	//Key Press
            rfb.writeKeyEvent(key, true);
            //Key Release
            rfb.writeKeyEvent(key, false);

            // Reset modifiers after
            if (shift) {
               shift = false;
               rfb.writeKeyEvent(0xffe1, false);
            }
            if (alt) {
               alt = false;
               rfb.writeKeyEvent(0xffe9, false);
            }
            if (control) {
               rfb.writeKeyEvent(0xffe3, false);
               control = false;
            }
            if (meta) {
               rfb.writeKeyEvent(0xffe7, false);
               meta = false;
            }
            rfb.os.write(rfb.eventBuf, 0, rfb.eventBufLen);
            //resetting the buffer
            rfb.eventBufLen = 0;
         }

         }
      }
      System.out.println();
   }

   void sendInit() throws Exception {
      rfb.os.write(0);

   }

   void sendTest() throws Exception {

      rfb.eventBufLen = 0;

      rfb.writeKeyEvent(0xffe1, true);
      rfb.writeKeyEvent(KeyEvent.VK_L, true);
      // Shift Modifier down
      rfb.writeKeyEvent(0xffe1, false);

      rfb.os.write(rfb.eventBuf, 0, rfb.eventBufLen);

      // rfb.eventBufLen=0;
      // rfb.writeKeyEvent( KeyEvent.KEY_RELEASED, true);
      // rfb.os.write(rfb.eventBuf, 0, rfb.eventBufLen);

      rfb.eventBufLen = 0;
      rfb.writeKeyEvent(KeyEvent.VK_I, true);
      rfb.os.write(rfb.eventBuf, 0, rfb.eventBufLen);

      rfb.eventBufLen = 0;

      rfb.writeKeyEvent(0xffe1, true);
      rfb.writeKeyEvent(KeyEvent.VK_L, true);
      // Shift Modifier down
      rfb.writeKeyEvent(0xffe1, false);
      rfb.os.write(rfb.eventBuf, 0, rfb.eventBufLen);

   }

   void sendClose() throws Exception {
      rfb.os.flush();

      rfb.writeVersionMsg();
      rfb.close();
   }

   void connectAndAuthenticate() throws Exception {

      showConnectionStatus("Connecting to " + host + ", port " + port + "...");

      VncViewer dummy = new VncViewer();

      rfb = new RfbProto(host, port, dummy);
      showConnectionStatus("Connected to server");

      rfb.readVersionMsg();
      showConnectionStatus("RFB server supports protocol version " + rfb.serverMajor + "." + rfb.serverMinor);

      rfb.writeVersionMsg();
      showConnectionStatus("Using RFB protocol version " + rfb.clientMajor + "." + rfb.clientMinor);

      int secType = rfb.negotiateSecurity();
      int authType;
      if (secType == RfbProto.SecTypeTight) {
         showConnectionStatus("Enabling TightVNC protocol extensions");
         rfb.setupTunneling();
         authType = rfb.negotiateAuthenticationTight();
      } else {
         authType = secType;
      }

      switch (authType) {
      case RfbProto.AuthNone:
         showConnectionStatus("No authentication needed");
         rfb.authenticateNone();
         break;
      case RfbProto.AuthVNC:
         showConnectionStatus("Performing standard VNC authentication");
         if (passwordParam != null) {
            try {
               rfb.authenticateVNC(passwordParam);
            } catch (Exception ex) {
               System.err.println("Error authenticating " + ex.toString());
               System.exit(-1);
            }
         } else {
            System.err.println("Server requires a password");
            System.exit(-1);
         }
         break;
      default:
         throw new Exception("Unknown authentication scheme " + authType);
      }
   }

   void showConnectionStatus(String msg) {
      System.out.println(msg);
      return;
   }

   static ArrayList<Integer> stringToKeyCodesList(String fullString) {

      String parseString = fullString;

      boolean found = false;
      String match = "";
      ArrayList<Integer> finalSequence = new ArrayList<Integer>();

      while (parseString.length() > 0) {

         Iterator<String> modifiersIterator = VncMappings.MODIFIER_MAP.keySet().iterator();
         while (modifiersIterator.hasNext() && !found) {
            String modifier = modifiersIterator.next();
            if (parseString.startsWith(modifier)) {
               int code = VncMappings.MODIFIER_MAP.get(modifier);
               finalSequence.add(code);
               found = true;
               match = modifier;
            }
         }

         Iterator<String> specialKeysIterator = VncMappings.SPECIAL_KEYMAP.keySet().iterator();
         while (specialKeysIterator.hasNext() && !found) {
            String specialKey = specialKeysIterator.next();
            if (parseString.startsWith(specialKey)) {
               int code = VncMappings.SPECIAL_KEYMAP.get(specialKey);
               int b = code + 0xff00;

               finalSequence.add(b);
               found = true;
               match = specialKey;

            }
         }

         Iterator<String> SequencesIterator = VncMappings.SEQUENCES_MAP.keySet().iterator();
         while (SequencesIterator.hasNext() && !found) {
            String sequence = SequencesIterator.next();
            if (parseString.startsWith(sequence)) {
               Integer keycodes[] = VncMappings.SEQUENCES_MAP.get(sequence);

               for (int i = 0; i < keycodes.length; i++) {
                  finalSequence.add(keycodes[i]);
               }
               found = true;
               match = sequence;
            }
         }

         Iterator<String> KeysIterator = VncMappings.KEYMAP.keySet().iterator();
         while (KeysIterator.hasNext() && !found) {
            String key = KeysIterator.next();
            if (parseString.startsWith(key)) {
               int code = VncMappings.KEYMAP.get(key);
               finalSequence.add(code);
               found = true;
               match = key;

            }
         }

         if (found) {
            parseString = parseString.substring(match.length());
            match = "";
            found = false;
         } else {
            // Pop the character.
            parseString = parseString.substring(1);
         }

      }

      return finalSequence;

   }

}
