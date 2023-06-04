package com.example.algorithms.infrastructure

class RandomProblem {
    fun getProblemNumber(): Int {
        val unsolvedProblems = intArrayOf(
            110,
            111,
            112,
            119,
            168,
            169,
            190,
            191,
            202,
            203,
            205,
            228,
            231,
            232,
            234,
            258,
            263,
            278,
            303,
            338,
            349,
            367,
            389,
            401,
            414,
        )

        val trees = intArrayOf(
            100,
            104,
            108,
            145,
            226,
            257,
            404,
        )

        val topQuestions = intArrayOf(
            4,
            5,
            10,
            15,
            17,
            22,
            23,
            33,
            34,
            36,
            38,
            41,
            42,
            44,
            46,
            48,
            49,
            50,
            53,
            54,
            62,
            73,
            75,
            76,
            79,
            84,
            91,
            103,
            104,
            105,
            108,
            116,
            122,
            124,
            127,
            130,
            131,
            134,
            138,
            140,
            146,
            148,
            149,
            150,
            152,
            155,
            169,
            172,
            179,
            189,
            198,
            204,
            208,
            210,
            212,
            215,
            218,
            230,
            236,
            239,
            279,
            289,
            295,
            297,
            300,
            315,
            322,
            324,
            328,
            329,
            334,
            341,
            347,
            378,
            380,
            384,
            395,
            454,
            1046
        )

        val bitManipulation = listOf(
            78,
            190,
            191,
            287,
            371
        )
        return topQuestions.random()
    }
}