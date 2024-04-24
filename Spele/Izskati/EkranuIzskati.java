package Spele.Izskati;

import Spele.K;

public class EkranuIzskati {

  private static final String[] GALVENAIS_EKRANS = {

    "\r▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓",//0
    "\r|                                           :::::                                                      |",//1
    "\r|   :::    :::  :::::::  ::::::  ::::::::  :::::::  :::    :::  .::::::.                               |",//2
    "\r|    :::  :::   ::....   ::         ::     ::....    :::  :::   ::    ::                               |",//3
    "\r|     ::::::    ::''''   ::         ::     ::''''     ::::::    ::''''::                               |",//4
    "\r|      ::::     :::::::  ::::::     ::     :::::::     ::::     ::    ::                               |",//5
    "\r|                                                                          ::::::                      |",//6
    "\r|                                                              ::.   .::  .::::::.      ::  .::::::.   |",//7
    "\r|                                                              ::::.::::  ::    ::      ::  ::    ::   |",//8
    "\r|                                                              :: ':' ::  ::''''::      ::  ::''''::   |",//9
    "\r|                                                              ::     ::  ::    ::  ::::'   ::    ::   |",//10
    "\r|                                                                                                      |",//11
    "\r|                                                                                                      |",//12
    "\r|                                                                                                      |",//13
    "\r|                                                                                                      |",//14
    "\r|                                                                                                      |",//15
    "\r|                                                                                                      |",//16
    "\r|                                                                                                      |",//17
    "\r|                                                                                                      |",//18
    "\r|                                                                                                      |",//19
    "\r|                                                                                                      |",//20
    "\r|                                                                                                      |",//21
    "\r|                                                                                                ::    |",//22
    "\r|                                                                   .         :::                ::    |",//23
    "\r|                                                                 .:::.       :::            .:  ::    |",//24
    "\r|                                                                  :::       .:::.          :::::::    |",//25
    "\r|                                                             [w]  :::   [s]  ':'   [ENTER]  ':        |",//26
    "\r|    L I E T O T A J S : _ _ _ _ _ _ _ _ _ _                                                           |",//27
    "\r|                      _                                     _                             _     v     |",//28
    "\r|    V E R S I J A : P A R V E I D O T A,  N O S P O D R I N A T A   U N   F U N K C I O N E J O S A   |",//29
    "\r|______________________________________________________________________________________________________|",//30
  };
  
  
  private static final String[] UZVARAS_EKRANS = {
    K.ZALS +
    "\r▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓",
    "\r|                                                                                                      |",
    "\r|          :::::::            ::                       ::::::                         ::::::: :::::::: |",
    "\r|      :: ..     .. .:::::       ::::::: :::::.  :::::::    ::     ::  .::::.      :: .:''':.    ::    |",
    "\r|      :: ::     :: :.....    ::    .:'  ::   ::    .:'  ::  ::   ::  ::    ::     :: ::...::    ::    |",
    "\r|      :: ::     ::  ''''::   ::  .:'    ::   ::  .:'    ::   :: ::   ::    ::     :: ::   ::    ::    |",
    "\r|  ::::'   ':::::'  :::::'    :: ::::::: :::::'  ::::::: ::    :::     '::::'  ::::'  ::   ::    ::    |",
    "\r|                                                                                                      |",
    "\r|  .::::::::::::...........                   ............:::::::::::::::::::...............        .| |",
    "\r| |'           ''''''''''''':::::::::::::::::''''''''''''''                 ''''''''''''''':::::::::'  |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                    _                                                                                 |",
    "\r|    S T R E S A   L I M E N I S :                                                                     |",
    "\r|                v       _                                                                             |",
    "\r|    A T L I K U S O   S E R K O C I N U   S K A I T S :                                               |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|______________________________________________________________________________________________________|"
  };
  
  private static final String[] ZAUDESANAS_EKRANS = {
      K.SARKANS +
    "\r▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓",
    "\r|                                                                                                      |",
    "\r|             :::::::                                             ::           ::::::             ::   |",
    "\r|        ::  ..     ..  .:::::     ::.   ::   .::::.   ::.   .::      ::'''.  .::::::.  ::::::::  ::   |",
    "\r|        ::  ::     ::  :.....     :::.  ::  ::    ::  :::: ::::  ::  ::...'  ::    ::     ::     ::   |",
    "\r|        ::  ::     ::   ''''::    :: ::.::  ::    ::  :: ':' ::  ::  ::':.   ::''''::     ::          |",
    "\r|    ::::'    ':::::'   :::::'     ::  ':::   '::::'   ::     ::  ::  ::  ::  ::    ::     ::     ::   |",
    "\r|                                                                                                      |",
    "\r|    ''''''''''''''''''''''''''''''''''''''''''''::''                                                  |",
    "\r|                                             ..::..................................................   |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|          v                                                                                           |",
    "\r|    M I R S A N A S   I E M E S L S :                                                                 |",
    "\r|                        _                                                                             |",
    "\r|    S E K U N D E S   L I D Z   6 A M :                                                               |",
    "\r|                                                                                                      |",
    "\r|    I E T E I K U M S :                                                                               |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|______________________________________________________________________________________________________|"
  };

  private static final String[] KARATAVU_EKRANS = {
    K.GRAMATA +
    "\r                                                                                                        ",
    "\r __.......-----'''''''''''''''''''''-----------...._....-------------''''''''''''''''''--------......__ ",
    "\r||                    _                            |                                                 |:|",
    "\r||           K  A  R  A  T  A  V  A  S             |                                                 | |",
    "\r||                                                 |                                                 | |",
    "\r||                                                 |                                                 | |",
    "\r||    B  U  R  T  I :                              |                                                 |:|",
    "\r||                                                |                                                  |:|",
    "\r||                                                |                                                  | |",
    "\r||                                                |                                                  |:|",
    "\r||                                                |                                                  | |",
    "\r||                                                |                                                  | |",
    "\r||                                                |                                                  | |",
    "\r||                                                |                                                  | |",
    "\r||                                                |                                                  | |",
    "\r||                                                |                                                  | |",
    "\r||                                                |                                                  | |",
    "\r||                                                |                                                  | |",
    "\r||                                                |                                                  | |",
    "\r||                                                |                                                  | |",
    "\r||                                                |                                                  | |",
    "\r||                                                |                                                  | |",
    "\r||                                                |                                                  | |",
    "\r||                                                 |                                                 |:|",
    "\r||                                                 |                                                 | |",
    "\r||       ''.                                       |                                                 | |",
    "\r||      Q    - P I E C E L T I E S                 |                                                 | |",
    "\r||   '..                                           |                  __________________             |:|",
    "\r||           ___________________                   |  __-------------- ---------------  ------------_|.|",
    "\r||___-------   _______________    ''''''''''----_.--'_----'''''''''''''  -----------  '''''''''''''---||",
    "\r|__----'''''''''              ''''''''''''-------|__|-------''''''''''''              '''''''''----____|"
  };

  private static final String[] REGISTRACIJAS_EKRANS = {

    "\r▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|      |''''''''''''''''''''''''''''''''''''''''''''''''''|                                            |",
    "\r|      |                                _     _           |                                            |",
    "\r|      |  I E V A D I E T   L I E T O T A J V A R D U :   |                                            |",
    "\r|      |                                                  |                                            |",
    "\r|      |     >>>             |                            |                                            |",
    "\r|      |__________________________________________________|                                            |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|      |''''''''''''''''''''''''''''''''''''''''''''''''''|                                            |",
    "\r|      |                                                  |                                            |",
    "\r|      |        I E V A D I E T   P A R O L I :           |                                            |",
    "\r|      |                                                  |                                            |",
    "\r|      |     >>>                  |                       |                                            |",
    "\r|      |__________________________________________________|                                            |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|      |''''''''''''''''''''''''''''''''''''''''''''''''''|                                            |",
    "\r|      |                          v _           _         |                                            |",
    "\r|      |  I E V A D I E T   D R O S I B A S   V A R D U : |                                            |",
    "\r|      |                                                  |                                            |",
    "\r|      |     >>>                  |                       |                                            |",
    "\r|      |__________________________________________________|                                            |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|       [ Q ] - A T P A K A L                             [ SAVE ] - I Z V E I D O T   K O N T U       |",
    "\r|                           '                                                                          |",
    "\r|______________________________________________________________________________________________________|"
  };

  private static final String[] KONTA_APSKATES_EKRANS = {

    "\r▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓",
    "\r|                                                                                                      |",
    "\r|                         .....------------''''''''''''''''''------------.....                         |",
    "\r|                         |                       _     _                    |                         |",
    "\r|                         |           L I E T O T A J V A R D S :            |                         |",
    "\r|                         |                                                  |                         |",
    "\r|                         |                                                  |                         |",
    "\r|                         |__________________________________________________|                         |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|   .....---------'''''''''''''''---------.....          .....---------'''''''''''''''---------.....   |",
    "\r|   |                                         |          |            v _           _              |   |",
    "\r|   |              P A R O L E :              |          |      D R O S I B A S   V A R D S :      |   |",
    "\r|   |                                         |          |                                         |   |",
    "\r|   |                                         |          |                                         |   |",
    "\r|   |_________________________________________|          |_________________________________________|   |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                            _                                         _                               |",
    "\r|        [ ATC ] - A T C E R E T I E S   M A N I         [ DEL ] - D Z E S T   K O N T U               |",
    "\r|                            _                                                  _                      |",
    "\r|        [ RED ] - R E D I G E T   D A T U S             [ SAVE ] - S A G L A B A T   D A T U S        |",
    "\r|                          '                                                 _                         |",
    "\r|        [ IZI ] - I Z I E T   N O   K O N T A           [ RESET ] - N O D Z E S T   D A T U S         |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|      [ Q ] - A T P A K A L                                                                           |",
    "\r|                          '                                                                           |",
    "\r|______________________________________________________________________________________________________|"
  };

  private static final String[] KONTA_IZVELES_EKRANS = {

    "\r▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                          |  ::  .:    .:::::.    ::.   :: :::::::: .:''':  |                         |",
    "\r|                          |  ::.:'     ::   ::    ::':. ::    ::    :       |                         |",
    "\r|                          |  ::':.     ::   ::    :: ':.::    ::     '''':  |                         |",
    "\r|                          |  ::  ::    ':::::'    ::   '::    ::    :....'  |                         |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                |'''''''''''''''''''''''''''''''''''|                                 |",
    "\r|                                |                 _                 |                                 |",
    "\r|                                |       P I E S L E G T I E S       |                                 |",
    "\r|                                |___________________________________|                                 |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                |'''''''''''''''''''''''''''''''''''|                                 |",
    "\r|                                |                                   |                                 |",
    "\r|                                |    I Z V E I D O T   K O N T U    |                                 |",
    "\r|                                |___________________________________|                                 |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|           [ Q ] - A T P A K A L                                                                      |",
    "\r|                               '                                                                      |",
    "\r|______________________________________________________________________________________________________|",
  };

  private static final String[] PIESLEGSANAS_EKRANS = {

    "\r▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                     ::                        '''''                    ::                            |",
    "\r|          |  :::::.      :::::  .:''':  ::     :::::  .:::::. ::::::::      :::::  .:''':  |          |",
    "\r|          |  ::   :  ::  ::...  :       ::     ::...  ::         ::     ::  ::...  :       |          |",
    "\r|          |  ::'''   ::  ::'''   '''':  ::     ::'''  ::  '':    ::     ::  ::'''   '''':  |          |",
    "\r|          |  ::      ::  :::::  :....'  :::::  :::::  ':::::'    ::     ::  :::::  :....'  |          |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                         |''''''''''''''''''''''''''''''''''''''''''''''''''|                         |",
    "\r|                         |                                _     _           |                         |",
    "\r|                         |  I E V A D I E T   L I E T O T A J V A R D U :   |                         |",
    "\r|                         |                                                  |                         |",
    "\r|                         |     >>>             |                            |                         |",
    "\r|                         |__________________________________________________|                         |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                         |''''''''''''''''''''''''''''''''''''''''''''''''''|                         |",
    "\r|                         |                                                  |                         |",
    "\r|                         |        I E V A D I E T   P A R O L I :           |                         |",
    "\r|                         |                                                  |                         |",
    "\r|                         |     >>>                  |                       |                         |",
    "\r|                         |__________________________________________________|                         |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                            _                         |",
    "\r|       [ Q ] - A T P A K A L                   [ AIZMIRSU ] - A I Z M I R S A T   P A R O L I ?       |",
    "\r|                           '                                                                          |",
    "\r|______________________________________________________________________________________________________|",
  };

  private static final String[] DROSIBAS_VARDA_EKRANS = {

    "\r▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                     ::                        '''''                    ::                            |",
    "\r|          |  :::::.      :::::  .:''':  ::     :::::  .:::::. ::::::::      :::::  .:''':  |          |",
    "\r|          |  ::   :  ::  ::...  :       ::     ::...  ::         ::     ::  ::...  :       |          |",
    "\r|          |  ::'''   ::  ::'''   '''':  ::     ::'''  ::  '':    ::     ::  ::'''   '''':  |          |",
    "\r|          |  ::      ::  :::::  :....'  :::::  :::::  ':::::'    ::     ::  :::::  :....'  |          |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                         |''''''''''''''''''''''''''''''''''''''''''''''''''|                         |",
    "\r|                         |                          v _           _         |                         |",
    "\r|                         |  I E V A D I E T   D R O S I B A S   V A R D U : |                         |",
    "\r|                         |                                                  |                         |",
    "\r|                         |     >>>                  |                       |                         |",
    "\r|                         |__________________________________________________|                         |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|       [ Q ] - A T P A K A L                                                                          |",
    "\r|                           '                                                                          |",
    "\r|______________________________________________________________________________________________________|",
  };

  private static final String[] REDIGESANAS_EKRANS = {

    "\r▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|      |''''''''''''''''''''''''''''''''''''''''''''''''''|              |''''''''''''''''''''''|      |",
    "\r|      |                                _     _           |              |           _          |      |",
    "\r|      |  I E V A D I E T   L I E T O T A J V A R D U :   |              |  T A G A D E J I E : |      |",
    "\r|      |                                                  |              |                      |      |",
    "\r|      |     >>>             |                            |              | >>>                  |      |",
    "\r|      |__________________________________________________|              |                      |      |",
    "\r|                                                                        |                      |      |",
    "\r|                                                                        |                      |      |",
    "\r|      |''''''''''''''''''''''''''''''''''''''''''''''''''|              |                      |      |",
    "\r|      |                                                  |              |                      |      |",
    "\r|      |        I E V A D I E T   P A R O L I :           |              |                      |      |",
    "\r|      |                                                  |              |                      |      |",
    "\r|      |     >>>                  |                       |              | >>>                  |      |",
    "\r|      |__________________________________________________|              |                      |      |",
    "\r|                                                                        |                      |      |",
    "\r|                                                                        |                      |      |",
    "\r|      |''''''''''''''''''''''''''''''''''''''''''''''''''|              |                      |      |",
    "\r|      |                          v _           _         |              |                      |      |",
    "\r|      |  I E V A D I E T   D R O S I B A S   V A R D U : |              |                      |      |",
    "\r|      |                                                  |              |                      |      |",
    "\r|      |     >>>                  |                       |              | >>>                  |      |",
    "\r|      |__________________________________________________|              |______________________|      |",
    "\r|                                                                                                      |",
    "\r|                                                                                            _         |",
    "\r|       [ Q ] - A T P A K A L                                         [ SAVE ] - S A G L A B A T       |",
    "\r|                           '                                                                          |",
    "\r|______________________________________________________________________________________________________|",
  };


  private static final String[] TUKS_EKRANS = {

    "\r▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|                                                                                                      |",
    "\r|______________________________________________________________________________________________________|",
  };

  

  public static String[] [] visiEkrani = { // String[] - masīvs, String[] [] - viendimensijas masīvs, kurš satur masīvus, String[][] [] - divdimensiju masīvs, kurš satur masīvus.
    GALVENAIS_EKRANS,
    UZVARAS_EKRANS,
    ZAUDESANAS_EKRANS,
    KARATAVU_EKRANS,
    KONTA_IZVELES_EKRANS, 
    KONTA_APSKATES_EKRANS,
    REGISTRACIJAS_EKRANS,
    PIESLEGSANAS_EKRANS,
    DROSIBAS_VARDA_EKRANS,
    REDIGESANAS_EKRANS,
    TUKS_EKRANS,
  };
}
