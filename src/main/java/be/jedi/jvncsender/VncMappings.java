package be.jedi.jvncsender;

import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Sets.newTreeSet;

import java.awt.event.KeyEvent;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public class VncMappings {

   public static final Map<String, Integer> KEYMAP = createKeyMap();
   public static final Map<String, Integer> SPECIAL_KEYMAP = createSpecialKeyMap();
   public static final Map<String, Integer> MODIFIER_MAP = createModifierMap();
   public static final Map<String, Integer[]> SEQUENCES_MAP = createSequencesMap();

   static void printMaps() {
      for (String key : newTreeSet(concat(KEYMAP.keySet(), SPECIAL_KEYMAP.keySet(), MODIFIER_MAP.keySet(),
            SEQUENCES_MAP.keySet()))) {
         System.out.println(key);
      }
   }

   static Map<String, Integer> createKeyMap() {
      Builder<String, Integer> builder = ImmutableMap.builder();

      String key = "a";
      for (int i = 0; i < 26; i++) {
         int charValue = key.charAt(0);
         builder.put(String.valueOf((char) (charValue + i)), KeyEvent.VK_A + i);
      }

      key = "0";
      for (int i = 0; i < 10; i++) {
         int charValue = key.charAt(0);
         builder.put(String.valueOf((char) (charValue + i)), KeyEvent.VK_0 + i);
      }

      // builder.put("{", KeyEvent.VK_BRACELEFT);
      // builder.put("}", KeyEvent.VK_BRACERIGHT);

      builder.put("[", KeyEvent.VK_OPEN_BRACKET);
      builder.put("]", KeyEvent.VK_CLOSE_BRACKET);

      // builder.put("$", KeyEvent.VK_DOLLAR);
      builder.put("Û", KeyEvent.VK_EURO_SIGN);
      // builder.put("!", KeyEvent.VK_EXCLAMATION_MARK);
      builder.put("=", KeyEvent.VK_EQUALS);

      // builder.put("<", KeyEvent.VK_LESS);
      // builder.put(">", KeyEvent.VK_GREATER);
      builder.put("(", KeyEvent.VK_LEFT_PARENTHESIS);
      builder.put(")", KeyEvent.VK_RIGHT_PARENTHESIS);

      builder.put("-", KeyEvent.VK_MINUS);

      // builder.put("*", KeyEvent.VK_MULTIPLY);
      // builder.put("#", KeyEvent.VK_NUMBER_SIGN);
      builder.put(".", KeyEvent.VK_PERIOD);
      builder.put("+", KeyEvent.VK_PLUS);
      builder.put("/", KeyEvent.VK_SLASH);

      // builder.put("'", KeyEvent.VK_QUOTE);
      // builder.put("\"", KeyEvent.VK_QUOTEDBL);

      builder.put(",", KeyEvent.VK_COMMA);
      // builder.put(":", KeyEvent.VK_COLON);
      builder.put(";", KeyEvent.VK_SEMICOLON);
      builder.put(" ", KeyEvent.VK_SPACE);
      // builder.put("_", KeyEvent.VK_UNDERSCORE);
      // builder.put("&", KeyEvent.VK_AMPERSAND);
      // builder.put("@", KeyEvent.VK_AT);
      // / builder.put("`", KeyEvent.VK_BACK_QUOTE);
      builder.put("\\", KeyEvent.VK_BACK_SLASH);

      return builder.build();

   }

   static Map<String, Integer> createSpecialKeyMap() {
      Builder<String, Integer> builder = ImmutableMap.builder();

      builder.put("<ACCEPT>", KeyEvent.VK_ACCEPT);
      builder.put("<ADD>", KeyEvent.VK_ADD);
      // builder.put("<AMPERSAND>", KeyEvent.VK_AMPERSAND);
      builder.put("<ASTERISK>", KeyEvent.VK_ASTERISK);
      // builder.put("<AT>", KeyEvent.VK_AT);
      // builder.put("<BACK_QUOTE>", KeyEvent.VK_BACK_QUOTE);
      // builder.put("<BACK_TICK>", KeyEvent.VK_BACK_QUOTE);
      builder.put("<BACK_SLASH>", KeyEvent.VK_BACK_SLASH);
      builder.put("<BACKSPACE>", KeyEvent.VK_BACK_SPACE);
      // builder.put("<BRACELEFT>", KeyEvent.VK_BRACELEFT);
      // builder.put("<BRACE_RIGHT>", KeyEvent.VK_BRACERIGHT);
      builder.put("<CANCEL>", KeyEvent.VK_CANCEL);
      builder.put("<CAPS_LOCK>", KeyEvent.VK_CAPS_LOCK);
      builder.put("<CIRCUMFLEX>", KeyEvent.VK_CIRCUMFLEX);
      builder.put("<CLEAR>", KeyEvent.VK_CLEAR);
      builder.put("<CLOSE_BRACKET>", KeyEvent.VK_CLOSE_BRACKET);
      builder.put("<CODE_INPUT>", KeyEvent.VK_CODE_INPUT);
      // builder.put("<COLON>", KeyEvent.VK_COLON);
      builder.put("<COMMA>", KeyEvent.VK_COMMA);
      builder.put("<COMPOSE>", KeyEvent.VK_COMPOSE);
      builder.put("<CONTROL>", KeyEvent.VK_CONTROL);
      builder.put("<CONVERT>", KeyEvent.VK_CONVERT);
      builder.put("<COPY>", KeyEvent.VK_COPY);
      builder.put("<CUT>", KeyEvent.VK_CUT);
      builder.put("<DEAD_ABOVEDOT>", KeyEvent.VK_DEAD_ABOVEDOT);
      builder.put("<DEAD_ABOVERING>", KeyEvent.VK_DEAD_ABOVERING);
      builder.put("<DEAD_ACUTE>", KeyEvent.VK_DEAD_ACUTE);
      builder.put("<DEAD_BREVE>", KeyEvent.VK_DEAD_BREVE);
      builder.put("<DEAD_CARON>", KeyEvent.VK_DEAD_CARON);
      builder.put("<DEAD_CEDILLA>", KeyEvent.VK_DEAD_CEDILLA);
      builder.put("<DEAD_CIRCUMFLEX>", KeyEvent.VK_DEAD_CIRCUMFLEX);
      builder.put("<DEAD_DIAERESIS>", KeyEvent.VK_DEAD_DIAERESIS);
      builder.put("<DEAD_DOUBLEACUTE>", KeyEvent.VK_DEAD_DOUBLEACUTE);
      builder.put("<DEAD_GRAVE>", KeyEvent.VK_DEAD_GRAVE);
      builder.put("<DEAD_IOTA>", KeyEvent.VK_DEAD_IOTA);
      builder.put("<DEAD_MACRON>", KeyEvent.VK_DEAD_MACRON);
      builder.put("<DEAD_OGONEK>", KeyEvent.VK_DEAD_OGONEK);
      builder.put("<DEAD_SEMIVOICED_SOUND>", KeyEvent.VK_DEAD_SEMIVOICED_SOUND);
      builder.put("<DEAD_TILDE>", KeyEvent.VK_DEAD_TILDE);
      builder.put("<DEAD_VOICED_SOUND>", KeyEvent.VK_DEAD_VOICED_SOUND);
      builder.put("<DECIMAL>", KeyEvent.VK_DECIMAL);
      builder.put("<DELETE>", KeyEvent.VK_DELETE);
      builder.put("<DIVIDE>", KeyEvent.VK_DIVIDE);
      // builder.put("<DOLLAR>", KeyEvent.VK_DOLLAR);
      // builder.put("<DOWN>", KeyEvent.VK_DOWN);
      builder.put("<END>", KeyEvent.VK_END);
      builder.put("<ENTER>", KeyEvent.VK_ENTER);
      builder.put("<RETURN>", 13);

      builder.put("<EQUALS>", KeyEvent.VK_EQUALS);
      builder.put("<ESCAPE>", KeyEvent.VK_ESCAPE);
      builder.put("<ESC>", KeyEvent.VK_ESCAPE);
      builder.put("<EURO_SIGN>", KeyEvent.VK_EURO_SIGN);

      builder.put("<FINAL>", KeyEvent.VK_FINAL);
      builder.put("<FIND>", KeyEvent.VK_FIND);
      builder.put("<FULL_WIDTH>", KeyEvent.VK_FULL_WIDTH);
      // builder.put("<GREATER>", KeyEvent.VK_GREATER);
      builder.put("<HALF_WIDTH>", KeyEvent.VK_HALF_WIDTH);
      builder.put("<HELP>", KeyEvent.VK_HELP);
      builder.put("<HIRAGANA>", KeyEvent.VK_HIRAGANA);
      // builder.put("<HOME>", KeyEvent.VK_HOME);
      builder.put("<INPUT_METHOD_ON_OFF>", KeyEvent.VK_INPUT_METHOD_ON_OFF);
      builder.put("<INSERT>", KeyEvent.VK_INSERT);
      builder.put("<INVERTED_EXCLAMATION_MARK>", KeyEvent.VK_INVERTED_EXCLAMATION_MARK);
      builder.put("<JAPANESE_HIRAGANA>", KeyEvent.VK_JAPANESE_HIRAGANA);
      builder.put("<JAPANESE_KATAKANA>", KeyEvent.VK_JAPANESE_KATAKANA);
      builder.put("<JAPANESE_ROMAN>", KeyEvent.VK_JAPANESE_ROMAN);
      builder.put("<KANA>", KeyEvent.VK_KANA);
      builder.put("<KANA_LOCK>", KeyEvent.VK_KANA_LOCK);
      builder.put("<KANJI>", KeyEvent.VK_KANJI);
      builder.put("<KATAKANA>", KeyEvent.VK_KATAKANA);
      builder.put("<KP_DOWN>", KeyEvent.VK_KP_DOWN);
      builder.put("<KP_LEFT>", KeyEvent.VK_KP_LEFT);
      builder.put("<KP_RIGHT>", KeyEvent.VK_KP_RIGHT);
      builder.put("<KP_UP>", KeyEvent.VK_KP_UP);
      // builder.put("<LEFT>", KeyEvent.VK_LEFT);
      builder.put("<LEFT_PARENTHESIS>", KeyEvent.VK_LEFT_PARENTHESIS);
      // builder.put("<LESS>", KeyEvent.VK_LESS);
      builder.put("<META>", KeyEvent.VK_META);
      builder.put("<MINUS>", KeyEvent.VK_MINUS);
      builder.put("<MODECHANGE>", KeyEvent.VK_MODECHANGE);
      // builder.put("<MULTIPLY>", KeyEvent.VK_MULTIPLY);
      builder.put("<NONCONVERT>", KeyEvent.VK_NONCONVERT);
      builder.put("<NUM_LOCK>", KeyEvent.VK_NUM_LOCK);
      builder.put("<NUMLOCK>", KeyEvent.VK_NUM_LOCK);
      // builder.put("<NUMBER_SIGN>", KeyEvent.VK_NUMBER_SIGN);
      // builder.put("<HASH>", KeyEvent.VK_NUMBER_SIGN);
      builder.put("<NUMPAD0>", KeyEvent.VK_NUMPAD0);
      builder.put("<NUMPAD1>", KeyEvent.VK_NUMPAD1);
      builder.put("<NUMPAD2>", KeyEvent.VK_NUMPAD2);
      builder.put("<NUMPAD3>", KeyEvent.VK_NUMPAD3);
      builder.put("<NUMPAD4>", KeyEvent.VK_NUMPAD4);
      builder.put("<NUMPAD5>", KeyEvent.VK_NUMPAD5);
      builder.put("<NUMPAD6>", KeyEvent.VK_NUMPAD6);
      builder.put("<NUMPAD7>", KeyEvent.VK_NUMPAD7);
      builder.put("<NUMPAD8>", KeyEvent.VK_NUMPAD8);
      builder.put("<NUMPAD9>", KeyEvent.VK_NUMPAD9);
      builder.put("<OPEN_BRACKET>", KeyEvent.VK_OPEN_BRACKET);

      builder.put("<PASTE>", KeyEvent.VK_PASTE);
      builder.put("<PAUSE>", KeyEvent.VK_PAUSE);
      builder.put("<PERIOD>", KeyEvent.VK_PERIOD);
      builder.put("<PLUS>", KeyEvent.VK_PLUS);
      builder.put("<PREVIOUS_CANDIDATE>", KeyEvent.VK_PREVIOUS_CANDIDATE);
      builder.put("<PRINTSCREEN>", KeyEvent.VK_PRINTSCREEN);
      builder.put("<PROPS>", KeyEvent.VK_PROPS);
      builder.put("<RIGHT_PARENTHESIS>", KeyEvent.VK_RIGHT_PARENTHESIS);
      builder.put("<ROMAN_CHARACTERS>", KeyEvent.VK_ROMAN_CHARACTERS);
      builder.put("<SCROLL_LOCK>", KeyEvent.VK_SCROLL_LOCK);
      builder.put("<SEMICOLON>", KeyEvent.VK_SEMICOLON);
      builder.put("<SEPARATER>", KeyEvent.VK_SEPARATER);
      builder.put("<SEPARATOR>", KeyEvent.VK_SEPARATOR);
      builder.put("<SHIFT>", KeyEvent.VK_SHIFT);
      builder.put("<SLASH>", KeyEvent.VK_SLASH);
      builder.put("<SPACE>", KeyEvent.VK_SPACE);
      builder.put("<STOP>", KeyEvent.VK_STOP);
      builder.put("<SUBTRACT>", KeyEvent.VK_SUBTRACT);
      builder.put("<TAB>", KeyEvent.VK_TAB);
      builder.put("<UNDEFINIED>", KeyEvent.VK_UNDEFINED);
      builder.put("<UNDO>", KeyEvent.VK_UNDO);

      return builder.build();
   }

   static Map<String, Integer> createModifierMap() {

      Builder<String, Integer> builder = ImmutableMap.builder();

      // writeKeyEvent(0xffe3, (newModifiers & CTRL_MASK) != 0);
      // writeKeyEvent(0xffe1, (newModifiers & SHIFT_MASK) != 0);
      // writeKeyEvent(0xffe7, (newModifiers & META_MASK) != 0);
      // writeKeyEvent(0xffe9, (newModifiers & ALT_MASK) != 0);

      builder.put("<SHIFT>", 0xffe1);
      builder.put("<ALT>", 0xffe9);
      builder.put("<CONTROL>", 0xffe3);
      builder.put("<META>", 0xffe7);

      // builder.put("<SHIFT>", KeyEvent.VK_SHIFT);
      // builder.put("<ALT>", KeyEvent.VK_ALT);
      // builder.put("<CONTROL>", KeyEvent.VK_CONTROL);
      // builder.put("<META>", KeyEvent.VK_META);

      return builder.build();

   }

   static Map<String, Integer[]> createSequencesMap() {
      Builder<String, Integer[]> builder = ImmutableMap.builder();

      String key = "A";
      for (int i = 0; i < 26; i++) {
         int charValue = key.charAt(0);
         builder.put(String.valueOf((char) (charValue + i)), new Integer[] { 0xffe1, KeyEvent.VK_A + i });
      }

      builder.put("<BACK_TICK>", new Integer[] { KeyEvent.VK_Z + 6 });
      builder.put("<BACK_QUOTE>", new Integer[] { KeyEvent.VK_Z + 6 });
      builder.put("`", new Integer[] { KeyEvent.VK_Z + 6 });

      builder.put("~", new Integer[] { 0xffe1, KeyEvent.VK_Z + 6 });
      builder.put("<TILDE>", new Integer[] { 0xffe1, KeyEvent.VK_Z + 6 });

      builder.put("<QUESTION_MARK>", new Integer[] { 0xffe1, KeyEvent.VK_SLASH });
      builder.put("?", new Integer[] { 0xffe1, KeyEvent.VK_SLASH });
      builder.put("<PIPE>", new Integer[] { 0xffe1, KeyEvent.VK_BACK_SLASH });
      builder.put("|", new Integer[] { 0xffe1, KeyEvent.VK_BACK_SLASH });
      builder.put("<COLON>", new Integer[] { 0xffe1, KeyEvent.VK_SEMICOLON });
      builder.put(":", new Integer[] { 0xffe1, KeyEvent.VK_SEMICOLON });

      builder.put("<AMPERSAND>", new Integer[] { 0xffe1, KeyEvent.VK_7 });
      builder.put("&", new Integer[] { 0xffe1, KeyEvent.VK_7 });

      builder.put("<EXCLAMATION_MARK>", new Integer[] { 0xffe1, KeyEvent.VK_1 });
      builder.put("!", new Integer[] { 0xffe1, KeyEvent.VK_1 });
      builder.put("<AT>", new Integer[] { 0xffe1, KeyEvent.VK_2 });
      builder.put("@", new Integer[] { 0xffe1, KeyEvent.VK_2 });
      builder.put("<DOLLAR>", new Integer[] { 0xffe1, KeyEvent.VK_4 });
      builder.put("$", new Integer[] { 0xffe1, KeyEvent.VK_4 });

      builder.put("<UNDERSCORE>", new Integer[] { 0xffe1, KeyEvent.VK_MINUS });
      builder.put("_", new Integer[] { 0xffe1, KeyEvent.VK_MINUS });

      builder.put("<BRACELEFT>", new Integer[] { 0xffe1, KeyEvent.VK_OPEN_BRACKET });
      builder.put("{", new Integer[] { 0xffe1, KeyEvent.VK_OPEN_BRACKET });

      builder.put("<BRACERIGHT>", new Integer[] { 0xffe1, KeyEvent.VK_CLOSE_BRACKET });
      builder.put("}", new Integer[] { 0xffe1, KeyEvent.VK_CLOSE_BRACKET });

      builder.put("<PERCENT>", new Integer[] { 0xffe1, KeyEvent.VK_5 });
      builder.put("%", new Integer[] { 0xffe1, KeyEvent.VK_5 });

      builder.put("<RETURN>", new Integer[] { 0xff0d });

      builder.put("<MULTIPLY>", new Integer[] { 0xffe1, 0x2a });
      builder.put("*", new Integer[] { 0xffe1, 0x2a });

      builder.put("<QUOTE>", new Integer[] { 0x27 });
      builder.put("'", new Integer[] { 0x27 });

      builder.put("<QUOTEDBL>", new Integer[] { 0xffe1, 0x27 });
      builder.put("\"", new Integer[] { 0xffe1, 0x27 });

      builder.put("<NUMBER_SIGN>", new Integer[] { 0xffe1, 0x23 });
      builder.put("#", new Integer[] { 0xffe1, 0x23 });

      builder.put("<HASH>", new Integer[] { 0xffe1, 0x23 });

      builder.put("<F1>", new Integer[] { 0xffbe });
      builder.put("<F2>", new Integer[] { 0xffbf });
      builder.put("<F3>", new Integer[] { 0xffc0 });
      builder.put("<F4>", new Integer[] { 0xffc1 });
      builder.put("<F5>", new Integer[] { 0xffc2 });
      builder.put("<F6>", new Integer[] { 0xffc3 });
      builder.put("<F7>", new Integer[] { 0xffc4 });
      builder.put("<F8>", new Integer[] { 0xffc5 });
      builder.put("<F9>", new Integer[] { 0xffc6 });
      builder.put("<F10>", new Integer[] { 0xffc7 });
      builder.put("<F11>", new Integer[] { 0xffc8 });
      builder.put("<F12>", new Integer[] { 0xffc9 });
      builder.put("<F13>", new Integer[] { 0xffca });
      builder.put("<F14>", new Integer[] { 0xffcb });
      builder.put("<F15>", new Integer[] { 0xffcc });
      builder.put("<F16>", new Integer[] { 0xffcd });
      builder.put("<F17>", new Integer[] { 0xffce });
      builder.put("<F18>", new Integer[] { 0xffcf });
      builder.put("<F19>", new Integer[] { 0xffd0 });
      builder.put("<F20>", new Integer[] { 0xffd1 });
      builder.put("<F21>", new Integer[] { 0xffd2 });
      builder.put("<F22>", new Integer[] { 0xffd3 });
      builder.put("<F23>", new Integer[] { 0xffd4 });
      builder.put("<F24>", new Integer[] { 0xffd5 });
      builder.put("<F25>", new Integer[] { 0xffd6 });
      builder.put("<F35>", new Integer[] { 0xffe0 });

      builder.put("<HOME>", new Integer[] { 0xff50 });
      builder.put("<LEFT>", new Integer[] { 0xff51 });
      builder.put("<UP>", new Integer[] { 0xff52 });
      builder.put("<RIGHT>", new Integer[] { 0xff53 });
      builder.put("<DOWN>", new Integer[] { 0xff54 });
      builder.put("<PAGE_UP>", new Integer[] { 0xff55 });
      builder.put("<PAGE_DOWN>", new Integer[] { 0xff56 });
      builder.put("<END>", new Integer[] { 0xff57 });
      builder.put("<INSERT>", new Integer[] { 0xff63 });

      return builder.build();

   }

}
