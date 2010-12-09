package be.jedi.jvncsender;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class VncMappings {
	
	// http://stackoverflow.com/questions/507602/how-to-initialise-a-static-map-in-java
	 public static final Map< String, Integer> KeyMap = createKeyMap();
	 public static final Map< String, Integer> SpecialKeyMap = createSpecialKeyMap();
	 public static final Map< String, Integer> ModifierMap = createModifierMap();
	 public static final Map< String, Integer[]> SequencesMap = createSequencesMap();
	

	 static void printMaps() {

		 List sortedKeys=new ArrayList(KeyMap.keySet());
		 sortedKeys.addAll(SpecialKeyMap.keySet());
		 sortedKeys.addAll(ModifierMap.keySet());
		 sortedKeys.addAll(SequencesMap.keySet());

		 Collections.sort(sortedKeys);
		 Iterator<String> keymaps=sortedKeys.iterator();		 
		 while (keymaps.hasNext()) {
			 System.out.println(keymaps.next());
		 }
	 }
	 
	 static Map<String, Integer> createKeyMap() {
		Map<String, Integer> result = new HashMap<String, Integer>();

		String key="a";
		for (int i=0; i< 26 ; i++) {
			int charValue=key.charAt(0);
			result.put(String.valueOf((char) (charValue+i)), KeyEvent.VK_A + i);    	  
		}

		key="0";
		for (int i=0; i< 10 ; i++) {
			int charValue=key.charAt(0);
			result.put(String.valueOf((char) (charValue+i)), KeyEvent.VK_0 + i);   
		}

//		result.put("{", KeyEvent.VK_BRACELEFT);
//		result.put("}", KeyEvent.VK_BRACERIGHT);

		result.put("[", KeyEvent.VK_OPEN_BRACKET);
		result.put("]", KeyEvent.VK_CLOSE_BRACKET);

//		result.put("$", KeyEvent.VK_DOLLAR);
		result.put("Û", KeyEvent.VK_EURO_SIGN);
//		result.put("!", KeyEvent.VK_EXCLAMATION_MARK);
		result.put("=", KeyEvent.VK_EQUALS);

//		result.put("<", KeyEvent.VK_LESS);
//		result.put(">", KeyEvent.VK_GREATER);
		result.put("(", KeyEvent.VK_LEFT_PARENTHESIS);
		result.put(")", KeyEvent.VK_RIGHT_PARENTHESIS);

		result.put("-", KeyEvent.VK_MINUS);

//		result.put("*", KeyEvent.VK_MULTIPLY);
//		result.put("#", KeyEvent.VK_NUMBER_SIGN);
		result.put(".", KeyEvent.VK_PERIOD);
		result.put("+", KeyEvent.VK_PLUS);
		result.put("/", KeyEvent.VK_SLASH);

//		result.put("'", KeyEvent.VK_QUOTE);
//		result.put("\"", KeyEvent.VK_QUOTEDBL);

		result.put(",", KeyEvent.VK_COMMA);
//		result.put(":", KeyEvent.VK_COLON);
		result.put(";", KeyEvent.VK_SEMICOLON);
		result.put(" ", KeyEvent.VK_SPACE);
//		result.put("_", KeyEvent.VK_UNDERSCORE);
//		result.put("&", KeyEvent.VK_AMPERSAND);
//		result.put("@", KeyEvent.VK_AT);
	///		result.put("`", KeyEvent.VK_BACK_QUOTE);
		result.put("\\", KeyEvent.VK_BACK_SLASH);


		return Collections.unmodifiableMap(result);

	}

	 static Map<String, Integer> createSpecialKeyMap() {
		Map<String, Integer> result = new HashMap<String, Integer>();

		result.put("<ACCEPT>", KeyEvent.VK_ACCEPT);
		result.put("<ADD>", KeyEvent.VK_ADD);
//		result.put("<AMPERSAND>", KeyEvent.VK_AMPERSAND);
		result.put("<ASTERISK>", KeyEvent.VK_ASTERISK);
//		result.put("<AT>", KeyEvent.VK_AT);
//		result.put("<BACK_QUOTE>", KeyEvent.VK_BACK_QUOTE);
//		result.put("<BACK_TICK>", KeyEvent.VK_BACK_QUOTE);
		result.put("<BACK_SLASH>", KeyEvent.VK_BACK_SLASH);
		result.put("<BACKSPACE>", KeyEvent.VK_BACK_SPACE);
//		result.put("<BRACELEFT>", KeyEvent.VK_BRACELEFT);
//		result.put("<BRACE_RIGHT>", KeyEvent.VK_BRACERIGHT);
		result.put("<CANCEL>", KeyEvent.VK_CANCEL);
		result.put("<CAPS_LOCK>", KeyEvent.VK_CAPS_LOCK);
		result.put("<CIRCUMFLEX>", KeyEvent.VK_CIRCUMFLEX);
		result.put("<CLEAR>", KeyEvent.VK_CLEAR);
		result.put("<CLOSE_BRACKET>", KeyEvent.VK_CLOSE_BRACKET);
		result.put("<CODE_INPUT>", KeyEvent.VK_CODE_INPUT);
//		result.put("<COLON>", KeyEvent.VK_COLON);
		result.put("<COMMA>", KeyEvent.VK_COMMA);
		result.put("<COMPOSE>", KeyEvent.VK_COMPOSE);
		result.put("<CONTROL>", KeyEvent.VK_CONTROL);
		result.put("<CONVERT>", KeyEvent.VK_CONVERT);
		result.put("<COPY>", KeyEvent.VK_COPY);
		result.put("<CUT>", KeyEvent.VK_CUT);
		result.put("<DEAD_ABOVEDOT>", KeyEvent.VK_DEAD_ABOVEDOT);
		result.put("<DEAD_ABOVERING>", KeyEvent.VK_DEAD_ABOVERING);
		result.put("<DEAD_ACUTE>", KeyEvent.VK_DEAD_ACUTE);
		result.put("<DEAD_BREVE>", KeyEvent.VK_DEAD_BREVE);
		result.put("<DEAD_CARON>", KeyEvent.VK_DEAD_CARON);
		result.put("<DEAD_CEDILLA>", KeyEvent.VK_DEAD_CEDILLA);
		result.put("<DEAD_CIRCUMFLEX>", KeyEvent.VK_DEAD_CIRCUMFLEX);
		result.put("<DEAD_DIAERESIS>", KeyEvent.VK_DEAD_DIAERESIS);
		result.put("<DEAD_DIAERESIS>", KeyEvent.VK_DEAD_DIAERESIS);
		result.put("<DEAD_DOUBLEACUTE>", KeyEvent.VK_DEAD_DOUBLEACUTE);
		result.put("<DEAD_GRAVE>", KeyEvent.VK_DEAD_GRAVE);
		result.put("<DEAD_IOTA>", KeyEvent.VK_DEAD_IOTA);
		result.put("<DEAD_MACRON>", KeyEvent.VK_DEAD_MACRON);
		result.put("<DEAD_OGONEK>", KeyEvent.VK_DEAD_OGONEK);
		result.put("<DEAD_SEMIVOICED_SOUND>", KeyEvent.VK_DEAD_SEMIVOICED_SOUND);
		result.put("<DEAD_TILDE>", KeyEvent.VK_DEAD_TILDE);
		result.put("<DEAD_VOICED_SOUND>", KeyEvent.VK_DEAD_VOICED_SOUND);
		result.put("<DECIMAL>", KeyEvent.VK_DECIMAL);
		result.put("<DELETE>", KeyEvent.VK_DELETE);
		result.put("<DIVIDE>", KeyEvent.VK_DIVIDE);
//		result.put("<DOLLAR>", KeyEvent.VK_DOLLAR);
//		result.put("<DOWN>", KeyEvent.VK_DOWN);
		result.put("<END>", KeyEvent.VK_END);
		result.put("<ENTER>", KeyEvent.VK_ENTER);
		result.put("<RETURN>", 13);

		result.put("<EQUALS>", KeyEvent.VK_EQUALS);
		result.put("<ESCAPE>", KeyEvent.VK_ESCAPE);
		result.put("<ESC>", KeyEvent.VK_ESCAPE);
		result.put("<EURO_SIGN>", KeyEvent.VK_EURO_SIGN);

		result.put("<FINAL>", KeyEvent.VK_FINAL);
		result.put("<FIND>", KeyEvent.VK_FIND);
		result.put("<FULL_WIDTH>", KeyEvent.VK_FULL_WIDTH);
//		result.put("<GREATER>", KeyEvent.VK_GREATER);
		result.put("<HALF_WIDTH>", KeyEvent.VK_HALF_WIDTH);
		result.put("<HELP>", KeyEvent.VK_HELP);
		result.put("<HIRAGANA>", KeyEvent.VK_HIRAGANA);
//		result.put("<HOME>", KeyEvent.VK_HOME);
		result.put("<INPUT_METHOD_ON_OFF>", KeyEvent.VK_INPUT_METHOD_ON_OFF);
		result.put("<INSERT>", KeyEvent.VK_INSERT);
		result.put("<INVERTED_EXCLAMATION_MARK>", KeyEvent.VK_INVERTED_EXCLAMATION_MARK);
		result.put("<JAPANESE_HIRAGANA>", KeyEvent.VK_JAPANESE_HIRAGANA);
		result.put("<JAPANESE_KATAKANA>", KeyEvent.VK_JAPANESE_KATAKANA);
		result.put("<JAPANESE_ROMAN>", KeyEvent.VK_JAPANESE_ROMAN);
		result.put("<KANA>", KeyEvent.VK_KANA);
		result.put("<KANA_LOCK>", KeyEvent.VK_KANA_LOCK);
		result.put("<KANJI>", KeyEvent.VK_KANJI);
		result.put("<KATAKANA>", KeyEvent.VK_KATAKANA);
		result.put("<KP_DOWN>", KeyEvent.VK_KP_DOWN);
		result.put("<KP_LEFT>", KeyEvent.VK_KP_LEFT);
		result.put("<KP_RIGHT>", KeyEvent.VK_KP_RIGHT);
		result.put("<KP_UP>", KeyEvent.VK_KP_UP);
//		result.put("<LEFT>", KeyEvent.VK_LEFT);
		result.put("<LEFT_PARENTHESIS>", KeyEvent.VK_LEFT_PARENTHESIS);
//		result.put("<LESS>", KeyEvent.VK_LESS);
		result.put("<META>", KeyEvent.VK_META);
		result.put("<MINUS>", KeyEvent.VK_MINUS);
		result.put("<MODECHANGE>", KeyEvent.VK_MODECHANGE);
//		result.put("<MULTIPLY>", KeyEvent.VK_MULTIPLY);
		result.put("<NONCONVERT>", KeyEvent.VK_NONCONVERT);
		result.put("<NUM_LOCK>", KeyEvent.VK_NUM_LOCK);
		result.put("<NUMLOCK>", KeyEvent.VK_NUM_LOCK);
//		result.put("<NUMBER_SIGN>", KeyEvent.VK_NUMBER_SIGN);
//		result.put("<HASH>", KeyEvent.VK_NUMBER_SIGN);
		result.put("<NUMPAD0>", KeyEvent.VK_NUMPAD0);
		result.put("<NUMPAD1>", KeyEvent.VK_NUMPAD1);
		result.put("<NUMPAD2>", KeyEvent.VK_NUMPAD2);
		result.put("<NUMPAD3>", KeyEvent.VK_NUMPAD3);
		result.put("<NUMPAD4>", KeyEvent.VK_NUMPAD4);
		result.put("<NUMPAD5>", KeyEvent.VK_NUMPAD5);
		result.put("<NUMPAD6>", KeyEvent.VK_NUMPAD6);
		result.put("<NUMPAD7>", KeyEvent.VK_NUMPAD7);
		result.put("<NUMPAD8>", KeyEvent.VK_NUMPAD8);
		result.put("<NUMPAD9>", KeyEvent.VK_NUMPAD9);
		result.put("<OPEN_BRACKET>", KeyEvent.VK_OPEN_BRACKET);

		result.put("<PASTE>", KeyEvent.VK_PASTE);
		result.put("<PAUSE>", KeyEvent.VK_PAUSE);
		result.put("<PERIOD>", KeyEvent.VK_PERIOD);
		result.put("<PLUS>", KeyEvent.VK_PLUS);
		result.put("<PREVIOUS_CANDIDATE>", KeyEvent.VK_PREVIOUS_CANDIDATE);
		result.put("<PRINTSCREEN>", KeyEvent.VK_PRINTSCREEN);
		result.put("<PROPS>", KeyEvent.VK_PROPS);
		result.put("<RIGHT_PARENTHESIS>", KeyEvent.VK_RIGHT_PARENTHESIS);
		result.put("<ROMAN_CHARACTERS>", KeyEvent.VK_ROMAN_CHARACTERS);
		result.put("<SCROLL_LOCK>", KeyEvent.VK_SCROLL_LOCK);
		result.put("<SEMICOLON>", KeyEvent.VK_SEMICOLON);
		result.put("<SEPARATER>", KeyEvent.VK_SEPARATER);
		result.put("<SEPARATOR>", KeyEvent.VK_SEPARATOR);
		result.put("<SHIFT>", KeyEvent.VK_SHIFT);
		result.put("<SLASH>", KeyEvent.VK_SLASH);
		result.put("<SPACE>", KeyEvent.VK_SPACE);
		result.put("<STOP>", KeyEvent.VK_STOP);
		result.put("<SUBTRACT>", KeyEvent.VK_SUBTRACT);
		result.put("<TAB>", KeyEvent.VK_TAB);
		result.put("<UNDEFINIED>", KeyEvent.VK_UNDEFINED);
		result.put("<UNDO>", KeyEvent.VK_UNDO);

		return Collections.unmodifiableMap(result);
	}

	 static Map<String, Integer> createModifierMap() {
		Map<String, Integer> result = new HashMap<String, Integer>();

		//          writeKeyEvent(0xffe3, (newModifiers & CTRL_MASK) != 0);
		//          writeKeyEvent(0xffe1, (newModifiers & SHIFT_MASK) != 0);
		//          writeKeyEvent(0xffe7, (newModifiers & META_MASK) != 0);
		//          writeKeyEvent(0xffe9, (newModifiers & ALT_MASK) != 0);

		result.put("<SHIFT>", 0xffe1);
		result.put("<ALT>", 0xffe9);
		result.put("<CONTROL>", 0xffe3);
		result.put("<META>", 0xffe7);

		//      result.put("<SHIFT>", KeyEvent.VK_SHIFT);
		//      result.put("<ALT>", KeyEvent.VK_ALT);
		//      result.put("<CONTROL>", KeyEvent.VK_CONTROL);
		//      result.put("<META>", KeyEvent.VK_META);

		return Collections.unmodifiableMap(result);

	}

	 static Map<String, Integer[]> createSequencesMap() {
		Map<String, Integer[]> result = new HashMap<String, Integer[]>();

		String key="A";
		for (int i=0; i< 26 ; i++) {
			int charValue=key.charAt(0);
			result.put(String.valueOf((char) (charValue+i)),new Integer[] { 0xffe1,  KeyEvent.VK_A + i});    	  
		} 

		result.put("<BACK_TICK>", new Integer[] { KeyEvent.VK_Z+6 });
		result.put("<BACK_QUOTE>", new Integer[] { KeyEvent.VK_Z+6 });
		result.put("`", new Integer[] { KeyEvent.VK_Z+6 });

		result.put("~", new Integer[] {  0xffe1, KeyEvent.VK_Z+6 });
		result.put("<TILDE>", new Integer[] {  0xffe1, KeyEvent.VK_Z+6 });
		
		result.put("<QUESTION_MARK>", new Integer[] { 0xffe1, KeyEvent.VK_SLASH});
		result.put("?", new Integer[] { 0xffe1, KeyEvent.VK_SLASH});
		result.put("<PIPE>", new Integer[] { 0xffe1, KeyEvent.VK_BACK_SLASH});
		result.put("|", new Integer[] { 0xffe1, KeyEvent.VK_BACK_SLASH});
		result.put("<COLON>", new Integer[] { 0xffe1, KeyEvent.VK_SEMICOLON});
		result.put(":", new Integer[] { 0xffe1, KeyEvent.VK_SEMICOLON});

		result.put("<AMPERSAND>", new Integer[] { 0xffe1, KeyEvent.VK_7});
		result.put("&", new Integer[] { 0xffe1, KeyEvent.VK_7});

		result.put("<EXCLAMATION_MARK>", new Integer[] { 0xffe1, KeyEvent.VK_1});
		result.put("!", new Integer[] { 0xffe1, KeyEvent.VK_1});
		result.put("<AT>", new Integer[] { 0xffe1, KeyEvent.VK_2});
		result.put("@", new Integer[] { 0xffe1, KeyEvent.VK_2});
		result.put("<DOLLAR>", new Integer[] { 0xffe1, KeyEvent.VK_4});
		result.put("$", new Integer[] { 0xffe1, KeyEvent.VK_4});

		result.put("<UNDERSCORE>", new Integer[] { 0xffe1, KeyEvent.VK_MINUS});
		result.put("_", new Integer[] { 0xffe1, KeyEvent.VK_MINUS});

		result.put("<BRACELEFT>", new Integer[] { 0xffe1, KeyEvent.VK_OPEN_BRACKET});
		result.put("{", new Integer[] { 0xffe1, KeyEvent.VK_OPEN_BRACKET});

		result.put("<BRACERIGHT>", new Integer[] { 0xffe1, KeyEvent.VK_CLOSE_BRACKET});
		result.put("}", new Integer[] { 0xffe1, KeyEvent.VK_CLOSE_BRACKET});

		result.put("<PERCENT>", new Integer[] { 0xffe1, KeyEvent.VK_5});
		result.put("%", new Integer[] { 0xffe1, KeyEvent.VK_5});

		
		result.put("<RETURN>", new Integer[] { 0xff0d});

		result.put("<MULTIPLY>", new Integer[] { 0xffe1,0x2a});
		result.put("*", new Integer[] {0xffe1, 0x2a});

		result.put("<QUOTE>", new Integer[] { 0x27});
		result.put("'", new Integer[] { 0x27});

		result.put("<QUOTEDBL>", new Integer[] { 0xffe1, 0x27});
		result.put("\"", new Integer[] { 0xffe1, 0x27});



		result.put("<NUMBER_SIGN>", new Integer[] {0xffe1, 0x23});
		result.put("#",  new Integer[] {0xffe1, 0x23});

		result.put("<HASH>", new Integer[] {0xffe1, 0x23});

		result.put("<F1>", new Integer[] {0xffbe});
		result.put("<F2>", new Integer[] {0xffbf});
		result.put("<F3>", new Integer[] {0xffc0});
		result.put("<F4>",  new Integer[] {0xffc1});
		result.put("<F5>",  new Integer[] {0xffc2});
		result.put("<F6>",  new Integer[] {0xffc3});
		result.put("<F7>",  new Integer[] {0xffc4});
		result.put("<F8>",  new Integer[] {0xffc5});
		result.put("<F9>",  new Integer[] {0xffc6});
		result.put("<F10>",  new Integer[] {0xffc7});
		result.put("<F11>",  new Integer[] {0xffc8});
		result.put("<F12>",  new Integer[] {0xffc9});
		result.put("<F13>",  new Integer[] {0xffca});
		result.put("<F14>",  new Integer[] {0xffcb});
		result.put("<F15>",  new Integer[] {0xffcc});
		result.put("<F16>",  new Integer[] {0xffcd});
		result.put("<F17>", new Integer[] {0xffce});
		result.put("<F18>", new Integer[] {0xffcf});
		result.put("<F19>",  new Integer[] {0xffd0});
		result.put("<F20>",  new Integer[] {0xffd1});
		result.put("<F21>",  new Integer[] {0xffd2});
		result.put("<F22>",  new Integer[] {0xffd3});
		result.put("<F23>",  new Integer[] {0xffd4});
		result.put("<F24>",  new Integer[] {0xffd5});
		result.put("<F25>",  new Integer[] {0xffd6});
		result.put("<F35>",  new Integer[] {0xffe0});

		result.put("<HOME>",  new Integer[] {0xff50});
		result.put("<LEFT>",  new Integer[] {0xff51});
		result.put("<UP>",  new Integer[] {0xff52});
		result.put("<RIGHT>",  new Integer[] {0xff53});
		result.put("<DOWN>",  new Integer[] {0xff54});
		result.put("<PAGE_UP>",  new Integer[] {0xff55});		
		result.put("<PAGE_DOWN>",  new Integer[] {0xff56});		
		result.put("<END>",  new Integer[] {0xff57});		
		result.put("<INSERT>",  new Integer[] {0xff63});		


		return Collections.unmodifiableMap(result);

	}
	
	
}
