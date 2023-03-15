package com.kotlin.lec05

/**
 * Lec05Main 2023-03-05
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

fun validateScoreIsNotNegative(score: Int) {
	if (score < 0) {
		throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
	}
}

fun getPassOrFail(score: Int): String {
	if (score >= 50) { // 밑줄이 생기는 이유는 Expression인데 return을 사용하지 않아서
		return "Pass"
	} else {
		return "Fail"
	}
}

// Java - Statement : 프로그램의 문장, 하나의 값으로 도출되지 않는다
// Kotlin - Expression : 하나의 값으로 도출되는 문장

fun getPassOrFailWithReturn(score: Int): String {
	return if (score >= 50) { // if 문 앞에 return을 붙이고 각각의 값에 return을 삭제하는 패턴으로 사용 가능 -> 해당 방법때문에 3항 연산자 없음
		"Pass"
	} else {
		"Fail"
	}
}

fun getGrade(score: Int): String {
	return if (score in 0..100) {
		return if (score >= 90) {
			"A"
		} else if (score >= 80) {
			"B"
		} else if (score >= 70) {
			"C"
		} else {
			"D"
		}
	} else {
		throw IllegalArgumentException("정상 점수 아님")
	}
}

// 범위 비교는 .. 사용

fun getGradeWithSwitch(score: Int): String {
	return when(score / 10) {
		9 -> "A"
		8 -> "B"
		7 -> "C"
		else -> "D"
	}
}

// 자바의 switch case는 코틀린 when으로 변경됨
fun getGradeWithSwitchV2(score: Int): String {
	return when(score) {
		in 90..100 -> "A"
		in 80..89 -> "B"
		in 70..79 -> "C"
		else -> "D"
	}
}

fun startWithA(obj: Any): Boolean {
	return when(obj) {
		is String -> obj.startsWith("A") // instance of -> 형변환 (Object) 코틀린 as
		else -> false
	}
}

fun judgeNumber(number: Int) {
	when (number) {
		-1, 0, 1 -> println("조건 충족")
		else -> println("-1, 0, 1이 아님")
	}
}

