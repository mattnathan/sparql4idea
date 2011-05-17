/* The following code was generated by JFlex 1.4.3 on 17/05/11 15:07 */

package com.mn.plug.idea.sparql4idea.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 17/05/11 15:07 from the specification file
 * <tt>/home/matt/projects/opensource/github/sparql4idea/source/sparql4idea/src/com/mn/plug/idea/sparql4idea/lang/lexer/_SparqlLexer.flex</tt>
 */
class _SparqlLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\1\0\2\0\1\0\5\0\1\11\1\11\2\0\1\11\22\0\1\11"+
    "\1\55\1\0\1\0\1\0\1\0\1\53\1\0\1\13\1\14\1\0"+
    "\1\7\1\51\1\2\1\6\1\0\1\5\1\5\1\5\7\5\1\0"+
    "\1\50\1\1\1\54\1\3\1\0\1\0\1\21\1\20\1\27\1\33"+
    "\1\10\1\17\1\43\1\42\1\25\1\0\1\34\1\26\1\36\1\12"+
    "\1\37\1\23\1\0\1\24\1\22\1\30\1\32\1\0\1\41\1\4"+
    "\1\35\1\0\1\15\1\0\1\16\1\56\1\0\1\0\1\44\1\20"+
    "\1\27\1\40\1\10\1\17\1\43\1\42\1\25\1\0\1\34\1\26"+
    "\1\36\1\12\1\31\1\23\1\0\1\24\1\45\1\30\1\32\1\0"+
    "\1\41\1\4\1\35\1\0\1\46\1\52\1\47\162\0\11\0\1\0"+
    "\3\0\1\0\uff02\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\1\1\11\1\12\1\13\1\14\17\1\1\15"+
    "\1\16\1\17\1\20\1\21\2\1\1\22\1\23\1\1"+
    "\1\24\1\25\1\26\7\0\1\27\24\0\1\30\1\31"+
    "\1\32\1\33\1\0\1\34\6\0\1\35\2\0\1\36"+
    "\25\0\1\37\1\0\1\40\11\0\1\41\2\0\1\42"+
    "\11\0\1\43\1\44\1\0\1\45\4\0\1\46\1\47"+
    "\1\0\1\50\1\0\1\51\3\0\1\52\1\53\3\0"+
    "\1\54\1\55\1\56\1\57\1\0\1\60\4\0\1\61"+
    "\5\0\1\62\7\0\1\63\3\0\1\64\1\65\1\66"+
    "\1\67\1\70\1\0\1\71\1\0\1\72";

  private static int [] zzUnpackAction() {
    int [] result = new int[191];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\57\0\136\0\57\0\215\0\274\0\353\0\57"+
    "\0\57\0\u011a\0\57\0\57\0\57\0\57\0\u0149\0\u0178"+
    "\0\u01a7\0\u01d6\0\u0205\0\u0234\0\u0263\0\u0292\0\u02c1\0\u02f0"+
    "\0\u031f\0\u034e\0\u037d\0\u03ac\0\u03db\0\u01a7\0\57\0\57"+
    "\0\57\0\57\0\u040a\0\u0439\0\57\0\u0468\0\u0497\0\57"+
    "\0\57\0\u04c6\0\u04f5\0\u0524\0\u0553\0\u0582\0\u05b1\0\u05e0"+
    "\0\u060f\0\57\0\u063e\0\u066d\0\u069c\0\u06cb\0\u06fa\0\u0729"+
    "\0\u0758\0\u0787\0\u07b6\0\u07e5\0\u0814\0\u0843\0\u0872\0\u08a1"+
    "\0\u08d0\0\u08ff\0\u092e\0\u095d\0\u098c\0\u09bb\0\57\0\57"+
    "\0\57\0\57\0\u09ea\0\u09ea\0\u0a19\0\u0a48\0\u0a77\0\u0aa6"+
    "\0\u0ad5\0\u0b04\0\57\0\u0b33\0\u0b62\0\57\0\u0b91\0\u0bc0"+
    "\0\u0bef\0\u0c1e\0\u0c4d\0\u0c7c\0\u0cab\0\u0cda\0\u0d09\0\u0d38"+
    "\0\u0d67\0\u0d96\0\u0dc5\0\u0df4\0\u0e23\0\u0e52\0\u0e81\0\u0eb0"+
    "\0\u0edf\0\u0f0e\0\u0f3d\0\57\0\u0f6c\0\57\0\u0f9b\0\u0fca"+
    "\0\u0ff9\0\u1028\0\u1057\0\u1086\0\u10b5\0\u10e4\0\u1113\0\u1142"+
    "\0\u1171\0\u11a0\0\57\0\u11cf\0\u11fe\0\u122d\0\u125c\0\u128b"+
    "\0\u12ba\0\u12e9\0\u1318\0\u1347\0\57\0\57\0\u1376\0\57"+
    "\0\u13a5\0\u13d4\0\u1403\0\u1432\0\57\0\57\0\u1461\0\57"+
    "\0\u1490\0\57\0\u14bf\0\u14ee\0\u151d\0\57\0\57\0\u154c"+
    "\0\u157b\0\u15aa\0\57\0\57\0\57\0\57\0\u15d9\0\57"+
    "\0\u1608\0\u1637\0\u1666\0\u1695\0\57\0\u16c4\0\u16f3\0\u1722"+
    "\0\u1751\0\u1780\0\57\0\u17af\0\u17de\0\u180d\0\u183c\0\u186b"+
    "\0\u189a\0\u18c9\0\57\0\u18f8\0\u1927\0\u1956\0\57\0\57"+
    "\0\57\0\57\0\57\0\u1985\0\57\0\u19b4\0\57";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[191];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\2\1\6\1\7\1\10"+
    "\1\2\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\3\2\1\31\1\33\1\34"+
    "\1\2\1\35\1\36\1\22\1\37\1\40\1\41\1\42"+
    "\1\43\1\44\1\45\1\46\1\47\133\0\1\50\56\0"+
    "\1\51\7\0\1\6\1\52\1\0\1\53\53\0\1\52"+
    "\72\0\1\54\22\0\1\54\33\0\1\55\2\0\1\56"+
    "\1\57\16\0\1\55\33\0\1\60\7\0\1\61\3\0"+
    "\1\62\1\0\1\61\4\0\1\60\34\0\1\63\22\0"+
    "\1\63\21\0\1\64\10\0\1\65\6\0\1\66\13\0"+
    "\1\65\36\0\1\67\42\0\1\70\70\0\1\71\22\0"+
    "\1\71\32\0\1\72\3\0\1\73\16\0\1\72\43\0"+
    "\1\74\5\0\1\74\43\0\1\75\51\0\1\76\3\0"+
    "\1\77\1\100\44\0\1\101\54\0\1\102\10\0\1\103"+
    "\3\0\1\104\16\0\1\103\54\0\1\105\40\0\1\106"+
    "\104\0\1\107\57\0\1\110\57\0\1\111\60\0\1\112"+
    "\5\0\1\52\2\0\1\53\50\0\1\113\2\0\1\114"+
    "\1\0\1\113\105\0\1\115\46\0\1\116\67\0\2\117"+
    "\44\0\1\120\52\0\1\121\22\0\1\121\43\0\1\122"+
    "\60\0\1\123\50\0\1\124\66\0\1\125\44\0\1\126"+
    "\42\0\1\127\101\0\1\130\4\0\1\130\2\0\1\131"+
    "\40\0\1\132\1\133\3\0\1\134\36\0\1\135\102\0"+
    "\1\136\32\0\1\137\76\0\1\140\43\0\1\141\67\0"+
    "\1\142\61\0\1\143\4\0\1\143\43\0\1\144\53\0"+
    "\1\145\22\0\1\145\41\0\1\146\50\0\1\147\22\0"+
    "\1\147\21\0\1\150\67\0\1\151\22\0\1\151\17\0"+
    "\1\114\61\0\1\152\70\0\1\153\22\0\1\153\47\0"+
    "\1\154\50\0\1\155\36\0\1\156\60\0\1\157\54\0"+
    "\1\160\56\0\1\161\65\0\1\162\71\0\1\163\34\0"+
    "\1\164\72\0\1\165\57\0\1\166\55\0\1\167\75\0"+
    "\1\170\40\0\1\171\53\0\1\172\22\0\1\172\21\0"+
    "\1\173\70\0\1\174\22\0\1\174\36\0\1\175\41\0"+
    "\1\176\77\0\1\177\5\0\1\177\46\0\1\200\50\0"+
    "\1\201\22\0\1\201\42\0\1\202\52\0\1\203\55\0"+
    "\1\204\66\0\1\205\4\0\1\205\26\0\1\206\56\0"+
    "\1\207\101\0\1\210\4\0\1\210\45\0\1\211\57\0"+
    "\1\212\53\0\1\213\60\0\1\214\33\0\1\215\77\0"+
    "\1\216\61\0\1\217\53\0\1\220\67\0\1\221\50\0"+
    "\1\222\56\0\1\223\36\0\1\224\77\0\1\225\5\0"+
    "\1\225\43\0\1\226\44\0\1\227\70\0\1\230\62\0"+
    "\1\231\53\0\1\232\41\0\1\233\110\0\1\234\40\0"+
    "\1\235\62\0\1\236\36\0\1\237\52\0\1\240\62\0"+
    "\1\241\56\0\1\242\67\0\1\243\23\0\1\243\35\0"+
    "\1\244\62\0\1\245\40\0\1\246\71\0\1\247\66\0"+
    "\1\250\33\0\1\251\70\0\1\252\65\0\1\253\4\0"+
    "\1\253\42\0\1\254\62\0\1\255\60\0\1\256\45\0"+
    "\1\257\22\0\1\257\32\0\1\260\61\0\1\261\62\0"+
    "\1\262\65\0\1\263\41\0\1\264\22\0\1\264\41\0"+
    "\1\265\56\0\1\266\55\0\1\267\40\0\1\270\56\0"+
    "\1\271\76\0\1\272\54\0\1\273\72\0\1\274\44\0"+
    "\1\275\36\0\1\276\70\0\1\277\22\0\1\277\11\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6627];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\3\1\2\11\1\1\4\11"+
    "\20\1\4\11\2\1\1\11\2\1\2\11\1\1\7\0"+
    "\1\11\24\0\4\11\1\0\1\1\6\0\1\11\2\0"+
    "\1\11\25\0\1\11\1\0\1\11\11\0\1\1\2\0"+
    "\1\11\11\0\2\11\1\0\1\11\4\0\2\11\1\0"+
    "\1\11\1\0\1\11\3\0\2\11\3\0\4\11\1\0"+
    "\1\11\4\0\1\11\5\0\1\11\7\0\1\11\3\0"+
    "\5\11\1\0\1\11\1\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[191];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;


  _SparqlLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  _SparqlLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 206) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL.charAt(zzCurrentPosL++);
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL.charAt(zzCurrentPosL++);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 48: 
          { return KW_PREFIX;
          }
        case 59: break;
        case 27: 
          { return OP_HATHAT;
          }
        case 60: break;
        case 17: 
          { return OP_COMMA;
          }
        case 61: break;
        case 21: 
          { return OP_GE;
          }
        case 62: break;
        case 34: 
          { return LIT_TRUE;
          }
        case 63: break;
        case 23: 
          { return KW_BY;
          }
        case 64: break;
        case 7: 
          { return OP_PLUS;
          }
        case 65: break;
        case 5: 
          { return LIT_INTEGER;
          }
        case 66: break;
        case 33: 
          { return KW_LANG;
          }
        case 67: break;
        case 9: 
          { return OP_LROUND;
          }
        case 68: break;
        case 10: 
          { return OP_RROUND;
          }
        case 69: break;
        case 26: 
          { return OP_NE;
          }
        case 70: break;
        case 38: 
          { return KW_REGEX;
          }
        case 71: break;
        case 53: 
          { return KW_DESCRIBE;
          }
        case 72: break;
        case 43: 
          { return KW_UNION;
          }
        case 73: break;
        case 35: 
          { return KW_NAMED;
          }
        case 74: break;
        case 54: 
          { return KW_DATATYPE;
          }
        case 75: break;
        case 18: 
          { return OP_EQ;
          }
        case 76: break;
        case 40: 
          { return KW_IS_URI;
          }
        case 77: break;
        case 41: 
          { return KW_LIMIT;
          }
        case 78: break;
        case 11: 
          { return OP_LSQUARE;
          }
        case 79: break;
        case 3: 
          { return OP_MINUS;
          }
        case 80: break;
        case 20: 
          { return OP_LE;
          }
        case 81: break;
        case 28: 
          { return LIT_DOUBLE;
          }
        case 82: break;
        case 50: 
          { return KW_REDUCED;
          }
        case 83: break;
        case 39: 
          { return KW_IS_IRI;
          }
        case 84: break;
        case 13: 
          { return KW_A;
          }
        case 85: break;
        case 37: 
          { return KW_BOUND;
          }
        case 86: break;
        case 45: 
          { return KW_GRAPH;
          }
        case 87: break;
        case 46: 
          { return KW_FILTER;
          }
        case 88: break;
        case 2: 
          { return OP_LT;
          }
        case 89: break;
        case 56: 
          { return KW_IS_LITERAL;
          }
        case 90: break;
        case 57: 
          { return KW_CONSTRUCT;
          }
        case 91: break;
        case 30: 
          { return KW_STR;
          }
        case 92: break;
        case 49: 
          { return KW_OFFSET;
          }
        case 93: break;
        case 29: 
          { return KW_ASK;
          }
        case 94: break;
        case 52: 
          { return KW_OPTIONAL;
          }
        case 95: break;
        case 16: 
          { return OP_SEMI;
          }
        case 96: break;
        case 31: 
          { return KW_FROM;
          }
        case 97: break;
        case 58: 
          { return KW_LANGMATCHES;
          }
        case 98: break;
        case 22: 
          { return LIT_DECIMAL;
          }
        case 99: break;
        case 24: 
          { return OP_PIPEPIPE;
          }
        case 100: break;
        case 6: 
          { return OP_DOT;
          }
        case 101: break;
        case 36: 
          { return LIT_FALSE;
          }
        case 102: break;
        case 12: 
          { return OP_RSQUARE;
          }
        case 103: break;
        case 1: 
          { return BAD_CHARACTER;
          }
        case 104: break;
        case 4: 
          { return OP_RT;
          }
        case 105: break;
        case 55: 
          { return KW_DISTINCT;
          }
        case 106: break;
        case 19: 
          { return OP_NOT;
          }
        case 107: break;
        case 8: 
          { return WHITE_SPACE;
          }
        case 108: break;
        case 42: 
          { return KW_ORDER;
          }
        case 109: break;
        case 25: 
          { return OP_ANDAND;
          }
        case 110: break;
        case 44: 
          { return KW_WHERE;
          }
        case 111: break;
        case 14: 
          { return OP_LCURLY;
          }
        case 112: break;
        case 51: 
          { return KW_SAME_TERM;
          }
        case 113: break;
        case 47: 
          { return KW_SELECT;
          }
        case 114: break;
        case 15: 
          { return OP_RCURLY;
          }
        case 115: break;
        case 32: 
          { return KW_BASE;
          }
        case 116: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
