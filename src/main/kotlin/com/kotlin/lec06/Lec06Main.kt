package com.kotlin.lec06

/**
 * LecNMain 2023-03-05
 *
 * Copyright Naver Webtoon Corp. All rights Reserved.
 * Naver Webtoon Corp. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * @author yunyeon.choi@webtoonscorp.com
 * @since 2023-03-05
 * @description
 */
fun main() {
	//list()
	forExtension()
}

fun list() {
	var numbers = listOf(1L, 2L, 3L)

	// for each - in 뒤에는 Iterable 구현된 타입이라면 모두 가능
	for (number in numbers) {
		println(number)
	}
}

fun forExtension() {
	var numbers = listOf(1L, 2L, 3L, 4L, 5L, 6L)

//	for (i in 0..numbers.size) { // 마지막에 ArrayIndexOutOfBoundsException 발생
//		println(numbers[i])
//	}

	// 인덱스 사용한 for

	for (i in 0 until numbers.size) { // for each 구문 사용하라고 밑줄
		println("upTo: ${numbers[i]}")
	}

	// 인덱스 2씩 증가하는 for의 값 출력
	for (i in 0 until numbers.size step(2)) { // 아래와 같이 indices 사용하라고 밑줄
		println("upTo step v1: ${numbers[i]}")
	}

	// 인덱스 2씩 증가하는 for의 인덱스 출력
	for (i in numbers.indices step(2)) {
		println("upTo step v2: ${i}") // 중괄호 삭제하라고 밑줄 나오지만 유지하는게 가독성, 일괄수정, 정규 사용 등에 있어서 유리함
	}

	// 인덱스 감소하는 for
	for (i in numbers.size - 1 downTo (0)) {
		println("downTo: ${numbers[i]}")
	}

	// 인덱스 2씩 감소하는 for
	for (i in numbers.size - 1 downTo (0) step (2)) {
		println("downTo step: ${numbers[i]}")
	}
}

// progression(등차수열)과 range
// .. 은 범위를 의미하는 연산자인데 IntRange 는 IntProgression을 상속하는 클래스
// while은 자바와 동일