package Spele.Izskati;

import Spele.K;

public class EkranuIzskati {

    public static String[] [] ekranuAtjaunosana() {
        String[] [] atjaunotaisMasivs = {
            sakumaEkranaBildesAtjaunosana(),
            zaudesanasBildesAtjaunosana(),
            uzvarasBildesAtjaunosana(),
            karatavuEkrans
        };
        return atjaunotaisMasivs;
    }


    public static int izvelnesSkaits = 1;
    static String[] sakumaEkranaIzvelesVarduVarianti = {"", "", "", "", "", ""};
    public static String[] sakumaEkranaBildesAtjaunosana() {

        if (izvelnesSkaits == 1) { // Spēlēt.
            sakumaEkranaIzvelesVarduVarianti[0] = izvelnesBultinas[0] + " T U R P I N A T " + izvelnesBultinas[1];
        } else {
            sakumaEkranaIzvelesVarduVarianti[0] = "  T U R P I N A T  ";
        }

        if (izvelnesSkaits == 2) { // Spēlēt.
            sakumaEkranaIzvelesVarduVarianti[1] = izvelnesBultinas[0] + " S P E L E T " + izvelnesBultinas[1];
        } else {
            sakumaEkranaIzvelesVarduVarianti[1] = "  S P E L E T  ";
        }

        if (izvelnesSkaits == 3) {
            sakumaEkranaIzvelesVarduVarianti[2] = izvelnesBultinas[0] + " I E S T A T I J U M I " + izvelnesBultinas[1];
        } else {
            sakumaEkranaIzvelesVarduVarianti[2] = "  I E S T A T I J U M I  ";
        }

        if (izvelnesSkaits == 4) {
            sakumaEkranaIzvelesVarduVarianti[3] = izvelnesBultinas[0] + " P A M A C I B A " + izvelnesBultinas[1];
        } else {
            sakumaEkranaIzvelesVarduVarianti[3] = "  P A M A C I B A  ";
        }

        if (izvelnesSkaits == 5) {
            sakumaEkranaIzvelesVarduVarianti[4] = izvelnesBultinas[0] + " A K A U N T S " + izvelnesBultinas[1];
        } else {
            sakumaEkranaIzvelesVarduVarianti[4] = "  A K A U N T S  ";
        }

        if (izvelnesSkaits == 6) {
            sakumaEkranaIzvelesVarduVarianti[5] = izvelnesBultinas[0] + " I Z I E T " + izvelnesBultinas[1];
        } else {
            sakumaEkranaIzvelesVarduVarianti[5] = "  I Z I E T  ";
        }

        String[] sakumaEkranaIzvelne = {

            "\r▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓",
            "\r|                                           :::::                                                      |",
            "\r|   :::    :::  :::::::  ::::::  ::::::::  :::::::  :::    :::  .::::::.                               |",
            "\r|    :::  :::   ::....   ::         ::     ::....    :::  :::   ::    ::                               |",
            "\r|     ::::::    ::''''   ::         ::     ::''''     ::::::    ::''''::                               |",
            "\r|      ::::     :::::::  ::::::     ::     :::::::     ::::     ::    ::                               |",
            "\r|                                                                          ::::::                      |",
            "\r|                                                              ::.   .::  .::::::.      ::  .::::::.   |",
            "\r|                                                              ::::.::::  ::    ::      ::  ::    ::   |",
            "\r|                                                              :: ':' ::  ::''''::      ::  ::''''::   |",
            "\r|                                                              ::     ::  ::    ::  ::::'   ::    ::   |",
            "\r|             " + Spele.K.SARKANS + sakumaEkranaIzvelesVarduVarianti[0] + Spele.K.RESET + "                                                                      |",
            "\r|                                                                                                      |",
            "\r|               " + sakumaEkranaIzvelesVarduVarianti[1] + "                                                                        |",
            "\r|                                                                                                      |",
            "\r|          " + Spele.K.SARKANS + sakumaEkranaIzvelesVarduVarianti[2] + Spele.K.RESET + "                                                                   |",
            "\r|                                                                                                      |",
            "\r|             " + Spele.K.SARKANS + sakumaEkranaIzvelesVarduVarianti[3] + Spele.K.RESET + "                                                                      |",
            "\r|                                                                                                      |",
            "\r|              " + Spele.K.SARKANS + sakumaEkranaIzvelesVarduVarianti[4] + Spele.K.RESET + "                                                                       |",
            "\r|                                                                                                      |",
            "\r|                " + sakumaEkranaIzvelesVarduVarianti[5] + "                                                                         |",
            "\r|                                                                                                ::    |",
            "\r|                                                                   .         :::                ::    |",
            "\r|                                                                 .:::.       :::            .:  ::    |",
            "\r|                                                                  :::       .:::.          :::::::    |",
            "\r|                                                             [w]  :::   [s]  ':'   [ENTER]  ':        |",
            "\r|    L I E T O T A J S : _ _ _ _ _ _ _ _ _ _                                                           |",
            "\r|                                                                                                      |",
            "\r|    V E R S I J A : K A U T   K A S   S A L I P I N A T S   A R   L I M L E N T I                     |",
            "\r|______________________________________________________________________________________________________|",
        };

        return sakumaEkranaIzvelne;
    }

    static String[] izvelnesBultinas = {Spele.K.DEBESU_ZILS + ">", "<" + Spele.K.RESET};


    public static String[] zaudesanasBildesAtjaunosana() {

        String[] zaudesanasEkrans = {

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
            "\r|                                                                                                      |",
            "\r|    I E T E I K U M S :                                                                               |",
            "\r|                        _                                                                             |",
            "\r|    S E K U N D E S   L I D Z   6 A M :                                                               |",
            "\r|                    _                                                                                 |",
            "\r|    S T R E S A   L I M E N I S :                                                                     |",
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

        return zaudesanasEkrans;
    }

    public static String[] uzvarasBildesAtjaunosana() {

        String[] zaudesanasEkrans = {

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
            "\r|          v                                                                                           |",
            "\r|    M I R S A N A S   I E M E S L S :                                                                 |",
            "\r|                                                                                                      |",
            "\r|    I E T E I K U M S :                                                                               |",
            "\r|                        _                                                                             |",
            "\r|    S E K U N D E S   L I D Z   6 A M :                                                               |",
            "\r|                    _                                                                                 |",
            "\r|    S T R E S A   L I M E N I S :                                                                     |",
            "\r|          _   _ v                                                                                     |",
            "\r|    A T N A K U S O   S P O K U   S K A I T S :                                                       |",
            "\r|                v       _                                                                             |",
            "\r|    A T L I K U S O   S E R K O C I N U   S K A I T S :                                               |",
            "\r|                                                                                                      |",
            "\r|                                                                                                      |",
            "\r|                                                                                                      |",
            "\r|                                                                                                      |",
            "\r|                                                                                                      |",
            "\r|                                                                                                      |",
            "\r|                                                                                                      |",
            "\r|______________________________________________________________________________________________________|"
        };

        return zaudesanasEkrans;
    }

    
    static String[] karatavuEkrans = {
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
            "\r||                                                 |                                                 | |",
            "\r||                                                 |                                                 | |",
            "\r||                                                 |                  __________________             |:|",
            "\r||           ___________________                   |  __-------------- ---------------  ------------_|.|",
            "\r||___-------   _______________    ''''''''''----_.--'_----'''''''''''''  -----------  '''''''''''''---||",
            "\r|__----'''''''''              ''''''''''''-------|__|-------''''''''''''              '''''''''----____|"
    };



}
