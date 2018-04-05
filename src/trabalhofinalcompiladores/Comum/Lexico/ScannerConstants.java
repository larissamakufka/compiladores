package trabalhofinalcompiladores.Comum.Lexico;

public interface ScannerConstants {

    int[] SCANNER_TABLE_INDEXES
            = {
                0,
                82,
                86,
                87,
                279,
                280,
                280,
                280,
                280,
                280,
                280,
                280,
                280,
                281,
                292,
                293,
                294,
                294,
                295,
                358,
                360,
                361,
                361,
                361,
                363,
                363,
                373,
                384,
                384,
                384,
                384,
                446,
                639,
                830,
                830,
                840,
                841,
                841
            };

    int[][] SCANNER_TABLE
            = {
                {9, 1},
                {10, 1},
                {13, 1},
                {32, 1},
                {33, 2},
                {34, 3},
                {38, 4},
                {40, 5},
                {41, 6},
                {42, 7},
                {43, 8},
                {44, 9},
                {45, 10},
                {47, 11},
                {48, 12},
                {49, 13},
                {50, 13},
                {51, 13},
                {52, 13},
                {53, 13},
                {54, 13},
                {55, 13},
                {56, 13},
                {57, 13},
                {58, 14},
                {60, 15},
                {61, 16},
                {62, 17},
                {65, 18},
                {66, 18},
                {67, 18},
                {68, 18},
                {69, 18},
                {70, 18},
                {71, 18},
                {72, 18},
                {73, 18},
                {74, 18},
                {75, 18},
                {76, 18},
                {77, 18},
                {78, 18},
                {79, 18},
                {80, 18},
                {81, 18},
                {82, 18},
                {83, 18},
                {84, 18},
                {85, 18},
                {86, 18},
                {87, 18},
                {88, 18},
                {89, 18},
                {90, 18},
                {92, 19},
                {97, 18},
                {98, 18},
                {99, 18},
                {100, 18},
                {101, 18},
                {102, 18},
                {103, 18},
                {104, 18},
                {105, 18},
                {106, 18},
                {107, 18},
                {108, 18},
                {109, 18},
                {110, 18},
                {111, 18},
                {112, 18},
                {113, 18},
                {114, 18},
                {115, 18},
                {116, 18},
                {117, 18},
                {118, 18},
                {119, 18},
                {120, 18},
                {121, 18},
                {122, 18},
                {124, 20},
                {9, 1},
                {10, 1},
                {13, 1},
                {32, 1},
                {61, 21},
                {9, 3},
                {13, 3},
                {32, 3},
                {33, 3},
                {34, 22},
                {35, 3},
                {36, 3},
                {37, 3},
                {38, 3},
                {39, 3},
                {40, 3},
                {41, 3},
                {42, 3},
                {43, 3},
                {44, 3},
                {45, 3},
                {46, 3},
                {47, 3},
                {48, 3},
                {49, 3},
                {50, 3},
                {51, 3},
                {52, 3},
                {53, 3},
                {54, 3},
                {55, 3},
                {56, 3},
                {57, 3},
                {58, 3},
                {59, 3},
                {60, 3},
                {61, 3},
                {62, 3},
                {63, 3},
                {64, 3},
                {65, 3},
                {66, 3},
                {67, 3},
                {68, 3},
                {69, 3},
                {70, 3},
                {71, 3},
                {72, 3},
                {73, 3},
                {74, 3},
                {75, 3},
                {76, 3},
                {77, 3},
                {78, 3},
                {79, 3},
                {80, 3},
                {81, 3},
                {82, 3},
                {83, 3},
                {84, 3},
                {85, 3},
                {86, 3},
                {87, 3},
                {88, 3},
                {89, 3},
                {90, 3},
                {91, 3},
                {92, 23},
                {93, 3},
                {94, 3},
                {95, 3},
                {96, 3},
                {97, 3},
                {98, 3},
                {99, 3},
                {100, 3},
                {101, 3},
                {102, 3},
                {103, 3},
                {104, 3},
                {105, 3},
                {106, 3},
                {107, 3},
                {108, 3},
                {109, 3},
                {110, 3},
                {111, 3},
                {112, 3},
                {113, 3},
                {114, 3},
                {115, 3},
                {116, 3},
                {117, 3},
                {118, 3},
                {119, 3},
                {120, 3},
                {121, 3},
                {122, 3},
                {123, 3},
                {124, 3},
                {125, 3},
                {126, 3},
                {161, 3},
                {162, 3},
                {163, 3},
                {164, 3},
                {165, 3},
                {166, 3},
                {167, 3},
                {168, 3},
                {169, 3},
                {170, 3},
                {171, 3},
                {172, 3},
                {173, 3},
                {174, 3},
                {175, 3},
                {176, 3},
                {177, 3},
                {178, 3},
                {179, 3},
                {180, 3},
                {181, 3},
                {182, 3},
                {183, 3},
                {184, 3},
                {185, 3},
                {186, 3},
                {187, 3},
                {188, 3},
                {189, 3},
                {190, 3},
                {191, 3},
                {192, 3},
                {193, 3},
                {194, 3},
                {195, 3},
                {196, 3},
                {197, 3},
                {198, 3},
                {199, 3},
                {200, 3},
                {201, 3},
                {202, 3},
                {203, 3},
                {204, 3},
                {205, 3},
                {206, 3},
                {207, 3},
                {208, 3},
                {209, 3},
                {210, 3},
                {211, 3},
                {212, 3},
                {213, 3},
                {214, 3},
                {215, 3},
                {216, 3},
                {217, 3},
                {218, 3},
                {219, 3},
                {220, 3},
                {221, 3},
                {222, 3},
                {223, 3},
                {224, 3},
                {225, 3},
                {226, 3},
                {227, 3},
                {228, 3},
                {229, 3},
                {230, 3},
                {231, 3},
                {232, 3},
                {233, 3},
                {234, 3},
                {235, 3},
                {236, 3},
                {237, 3},
                {238, 3},
                {239, 3},
                {240, 3},
                {241, 3},
                {242, 3},
                {243, 3},
                {244, 3},
                {245, 3},
                {246, 3},
                {247, 3},
                {248, 3},
                {249, 3},
                {250, 3},
                {251, 3},
                {252, 3},
                {253, 3},
                {254, 3},
                {255, 3},
                {38, 24},
                {44, 25},
                {44, 25},
                {48, 26},
                {49, 13},
                {50, 13},
                {51, 13},
                {52, 13},
                {53, 13},
                {54, 13},
                {55, 13},
                {56, 13},
                {57, 13},
                {61, 27},
                {61, 28},
                {61, 29},
                {48, 18},
                {49, 18},
                {50, 18},
                {51, 18},
                {52, 18},
                {53, 18},
                {54, 18},
                {55, 18},
                {56, 18},
                {57, 18},
                {65, 18},
                {66, 18},
                {67, 18},
                {68, 18},
                {69, 18},
                {70, 18},
                {71, 18},
                {72, 18},
                {73, 18},
                {74, 18},
                {75, 18},
                {76, 18},
                {77, 18},
                {78, 18},
                {79, 18},
                {80, 18},
                {81, 18},
                {82, 18},
                {83, 18},
                {84, 18},
                {85, 18},
                {86, 18},
                {87, 18},
                {88, 18},
                {89, 18},
                {90, 18},
                {95, 30},
                {97, 18},
                {98, 18},
                {99, 18},
                {100, 18},
                {101, 18},
                {102, 18},
                {103, 18},
                {104, 18},
                {105, 18},
                {106, 18},
                {107, 18},
                {108, 18},
                {109, 18},
                {110, 18},
                {111, 18},
                {112, 18},
                {113, 18},
                {114, 18},
                {115, 18},
                {116, 18},
                {117, 18},
                {118, 18},
                {119, 18},
                {120, 18},
                {121, 18},
                {122, 18},
                {42, 31},
                {92, 32},
                {124, 33},
                {34, 3},
                {92, 3},
                {48, 34},
                {49, 34},
                {50, 34},
                {51, 34},
                {52, 34},
                {53, 34},
                {54, 34},
                {55, 34},
                {56, 34},
                {57, 34},
                {44, 25},
                {48, 26},
                {49, 26},
                {50, 26},
                {51, 26},
                {52, 26},
                {53, 26},
                {54, 26},
                {55, 26},
                {56, 26},
                {57, 26},
                {48, 18},
                {49, 18},
                {50, 18},
                {51, 18},
                {52, 18},
                {53, 18},
                {54, 18},
                {55, 18},
                {56, 18},
                {57, 18},
                {65, 18},
                {66, 18},
                {67, 18},
                {68, 18},
                {69, 18},
                {70, 18},
                {71, 18},
                {72, 18},
                {73, 18},
                {74, 18},
                {75, 18},
                {76, 18},
                {77, 18},
                {78, 18},
                {79, 18},
                {80, 18},
                {81, 18},
                {82, 18},
                {83, 18},
                {84, 18},
                {85, 18},
                {86, 18},
                {87, 18},
                {88, 18},
                {89, 18},
                {90, 18},
                {97, 18},
                {98, 18},
                {99, 18},
                {100, 18},
                {101, 18},
                {102, 18},
                {103, 18},
                {104, 18},
                {105, 18},
                {106, 18},
                {107, 18},
                {108, 18},
                {109, 18},
                {110, 18},
                {111, 18},
                {112, 18},
                {113, 18},
                {114, 18},
                {115, 18},
                {116, 18},
                {117, 18},
                {118, 18},
                {119, 18},
                {120, 18},
                {121, 18},
                {122, 18},
                {9, 31},
                {10, 31},
                {13, 31},
                {32, 31},
                {33, 31},
                {34, 31},
                {35, 31},
                {36, 31},
                {37, 31},
                {38, 31},
                {39, 31},
                {40, 31},
                {41, 31},
                {42, 35},
                {43, 31},
                {44, 31},
                {45, 31},
                {46, 31},
                {47, 31},
                {48, 31},
                {49, 31},
                {50, 31},
                {51, 31},
                {52, 31},
                {53, 31},
                {54, 31},
                {55, 31},
                {56, 31},
                {57, 31},
                {58, 31},
                {59, 31},
                {60, 31},
                {61, 31},
                {62, 31},
                {63, 31},
                {64, 31},
                {65, 31},
                {66, 31},
                {67, 31},
                {68, 31},
                {69, 31},
                {70, 31},
                {71, 31},
                {72, 31},
                {73, 31},
                {74, 31},
                {75, 31},
                {76, 31},
                {77, 31},
                {78, 31},
                {79, 31},
                {80, 31},
                {81, 31},
                {82, 31},
                {83, 31},
                {84, 31},
                {85, 31},
                {86, 31},
                {87, 31},
                {88, 31},
                {89, 31},
                {90, 31},
                {91, 31},
                {92, 31},
                {93, 31},
                {94, 31},
                {95, 31},
                {96, 31},
                {97, 31},
                {98, 31},
                {99, 31},
                {100, 31},
                {101, 31},
                {102, 31},
                {103, 31},
                {104, 31},
                {105, 31},
                {106, 31},
                {107, 31},
                {108, 31},
                {109, 31},
                {110, 31},
                {111, 31},
                {112, 31},
                {113, 31},
                {114, 31},
                {115, 31},
                {116, 31},
                {117, 31},
                {118, 31},
                {119, 31},
                {120, 31},
                {121, 31},
                {122, 31},
                {123, 31},
                {124, 31},
                {125, 31},
                {126, 31},
                {161, 31},
                {162, 31},
                {163, 31},
                {164, 31},
                {165, 31},
                {166, 31},
                {167, 31},
                {168, 31},
                {169, 31},
                {170, 31},
                {171, 31},
                {172, 31},
                {173, 31},
                {174, 31},
                {175, 31},
                {176, 31},
                {177, 31},
                {178, 31},
                {179, 31},
                {180, 31},
                {181, 31},
                {182, 31},
                {183, 31},
                {184, 31},
                {185, 31},
                {186, 31},
                {187, 31},
                {188, 31},
                {189, 31},
                {190, 31},
                {191, 31},
                {192, 31},
                {193, 31},
                {194, 31},
                {195, 31},
                {196, 31},
                {197, 31},
                {198, 31},
                {199, 31},
                {200, 31},
                {201, 31},
                {202, 31},
                {203, 31},
                {204, 31},
                {205, 31},
                {206, 31},
                {207, 31},
                {208, 31},
                {209, 31},
                {210, 31},
                {211, 31},
                {212, 31},
                {213, 31},
                {214, 31},
                {215, 31},
                {216, 31},
                {217, 31},
                {218, 31},
                {219, 31},
                {220, 31},
                {221, 31},
                {222, 31},
                {223, 31},
                {224, 31},
                {225, 31},
                {226, 31},
                {227, 31},
                {228, 31},
                {229, 31},
                {230, 31},
                {231, 31},
                {232, 31},
                {233, 31},
                {234, 31},
                {235, 31},
                {236, 31},
                {237, 31},
                {238, 31},
                {239, 31},
                {240, 31},
                {241, 31},
                {242, 31},
                {243, 31},
                {244, 31},
                {245, 31},
                {246, 31},
                {247, 31},
                {248, 31},
                {249, 31},
                {250, 31},
                {251, 31},
                {252, 31},
                {253, 31},
                {254, 31},
                {255, 31},
                {9, 32},
                {32, 32},
                {33, 32},
                {34, 32},
                {35, 32},
                {36, 32},
                {37, 32},
                {38, 32},
                {39, 32},
                {40, 32},
                {41, 32},
                {42, 32},
                {43, 32},
                {44, 32},
                {45, 32},
                {46, 32},
                {47, 32},
                {48, 32},
                {49, 32},
                {50, 32},
                {51, 32},
                {52, 32},
                {53, 32},
                {54, 32},
                {55, 32},
                {56, 32},
                {57, 32},
                {58, 32},
                {59, 32},
                {60, 32},
                {61, 32},
                {62, 32},
                {63, 32},
                {64, 32},
                {65, 32},
                {66, 32},
                {67, 32},
                {68, 32},
                {69, 32},
                {70, 32},
                {71, 32},
                {72, 32},
                {73, 32},
                {74, 32},
                {75, 32},
                {76, 32},
                {77, 32},
                {78, 32},
                {79, 32},
                {80, 32},
                {81, 32},
                {82, 32},
                {83, 32},
                {84, 32},
                {85, 32},
                {86, 32},
                {87, 32},
                {88, 32},
                {89, 32},
                {90, 32},
                {91, 32},
                {92, 32},
                {93, 32},
                {94, 32},
                {95, 32},
                {96, 32},
                {97, 32},
                {98, 32},
                {99, 32},
                {100, 32},
                {101, 32},
                {102, 32},
                {103, 32},
                {104, 32},
                {105, 32},
                {106, 32},
                {107, 32},
                {108, 32},
                {109, 32},
                {110, 32},
                {111, 32},
                {112, 32},
                {113, 32},
                {114, 32},
                {115, 32},
                {116, 32},
                {117, 32},
                {118, 32},
                {119, 32},
                {120, 32},
                {121, 32},
                {122, 32},
                {123, 32},
                {124, 32},
                {125, 32},
                {126, 32},
                {161, 32},
                {162, 32},
                {163, 32},
                {164, 32},
                {165, 32},
                {166, 32},
                {167, 32},
                {168, 32},
                {169, 32},
                {170, 32},
                {171, 32},
                {172, 32},
                {173, 32},
                {174, 32},
                {175, 32},
                {176, 32},
                {177, 32},
                {178, 32},
                {179, 32},
                {180, 32},
                {181, 32},
                {182, 32},
                {183, 32},
                {184, 32},
                {185, 32},
                {186, 32},
                {187, 32},
                {188, 32},
                {189, 32},
                {190, 32},
                {191, 32},
                {192, 32},
                {193, 32},
                {194, 32},
                {195, 32},
                {196, 32},
                {197, 32},
                {198, 32},
                {199, 32},
                {200, 32},
                {201, 32},
                {202, 32},
                {203, 32},
                {204, 32},
                {205, 32},
                {206, 32},
                {207, 32},
                {208, 32},
                {209, 32},
                {210, 32},
                {211, 32},
                {212, 32},
                {213, 32},
                {214, 32},
                {215, 32},
                {216, 32},
                {217, 32},
                {218, 32},
                {219, 32},
                {220, 32},
                {221, 32},
                {222, 32},
                {223, 32},
                {224, 32},
                {225, 32},
                {226, 32},
                {227, 32},
                {228, 32},
                {229, 32},
                {230, 32},
                {231, 32},
                {232, 32},
                {233, 32},
                {234, 32},
                {235, 32},
                {236, 32},
                {237, 32},
                {238, 32},
                {239, 32},
                {240, 32},
                {241, 32},
                {242, 32},
                {243, 32},
                {244, 32},
                {245, 32},
                {246, 32},
                {247, 32},
                {248, 32},
                {249, 32},
                {250, 32},
                {251, 32},
                {252, 32},
                {253, 32},
                {254, 32},
                {255, 32},
                {48, 34},
                {49, 34},
                {50, 34},
                {51, 34},
                {52, 34},
                {53, 34},
                {54, 34},
                {55, 34},
                {56, 34},
                {57, 34},
                {92, 36}
            };

    int[] TOKEN_STATE = {0, 0, 35, -1, -1, 28, 29, 43, 41, 32, 42, 44, 3, 3, 27, 37, 30, 39, 2, -1, -1, 36, 5, -1, 33, -1, 3, 31, 38, 40, 2, -1, 0, 34, 4, -1, 0};

    int[] SPECIAL_CASES_INDEXES
            = {0, 0, 0, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21};

    String[] SPECIAL_CASES_KEYS
            = {"bool", "consts", "def", "end", "execute", "false", "float", "get", "ifFalse", "ifTrue", "input", "int", "print", "println", "set", "str", "true", "types", "var", "whileFalse", "whileTrue"};

    int[] SPECIAL_CASES_VALUES
            = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};

    String[] SCANNER_ERROR
            = {
                "símbolo inválido",
                "",
                "",
                "constante caractere inválida ou não finalizada",
                "símbolo inválido",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "comentário de bloco inválido ou não finalizado",
                "símbolo inválido",
                "",
                "",
                "constante caractere inválida ou não finalizada",
                "",
                "Erro identificando const_real7",
                "",
                "",
                "",
                "",
                "",
                "comentário de bloco inválido ou não finalizado",
                "",
                "",
                "",
                "Erro identificando <ignorar>9",
                ""
            };

}
