package com.kotlin.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

/**
 * Lec07Main 2023-03-05
 *
 * Copyright Naver Webtoon Corp. All rights Reserved.
 * Naver Webtoon Corp. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * @author yunyeon.choi@webtoonscorp.com
 * @since 2023-03-05
 * @description
 */
fun main() {

}

// try catch 구문
// Checked Exception과 Unchecked Exception
// try with resources (java 7부터 추가)

fun parseIntOrThrow(str: String): Int {
	try {
		return str.toInt()
	} catch (e: NumberFormatException) {
		throw IllegalArgumentException("${str}은 숫자가 아님")
	}
}

fun parseIntOrThrowV2(str : String): Int? {
	return try {
		str.toInt()
	} catch (e: NumberFormatException) {
		null
	}
}

// try catch final 동일

class FilePrinter {
	fun readFile() {
		var currentFile = File(".")
		var file = File(currentFile.absolutePath + "/a.txt")
		var reader = BufferedReader(FileReader(file))
		println(reader.readLine())
		reader.close()
	}
	// 자바와 다르게 IOException 처리에 대한 빨간줄 발생하지 않는다
	// 코틀린은 모두 Unchecked Exception이기 때문

	// 자원 사용 후 알아서 반환
	// try with resource 구문 대신 use라는 inline 확장함수 사용 (section 4에서 추가 설명)
	fun readFile(path: String) {
		BufferedReader(FileReader(path)).use { reader ->
			println(reader.readLine())
		}
	}
}

