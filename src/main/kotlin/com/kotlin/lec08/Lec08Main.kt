package com.kotlin.lec08

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
	repeat("*", 8, false)
	repeat("*", 8)
	repeat("*")

	repeatWithDefault("#")
	repeatWithDefault("#", 3)
	repeatWithDefault("#", 3, true)
	// 위 3개 호출은 동일 결과

//	repeatWithDefault("#", false) // 해당 구문은 에러 발생 -> named argument 사용 필요
	repeatWithDefault("#", useNewLine = false) // 매개변수 이름을 통해 직접 지정 -> builder를 만들지 않고 builder의 장점 활용

	printNameAndGender("Nick Furi", "MALE") // 순서 맞게 쓸 경우 이슈 없음
	printNameAndGender("MALE", "Nick Furi") // String으로 타입이 같을 때 순서 바뀌면 이슈 발생
	printNameAndGender(gender = "MALE", name = "Nick Furi") // named argument로 지정하면 해결
	// but 순서 지키는 편이 좋을듯 -> java 메소드를 가져와서 사용할 때는 named argument 사용 불가
	// JVM 상에서 java 코드가 byte code로 변환되었을 때 parameter 이름을 보존하고 있지 않음

	printAll("A", "B", "C")
	var array = arrayOf("A", "B", "C")
	//printAll(array) // 앞에 * 붙이지 않으면 컴파일 에러
	printAll(*array) // spread 연산자
}

// 함수 선언 문법
// default parameter
// named argument (parameter)
// 같은 타입의 여러 파라미터 받기 (가변인자)

// 자바를 코틀린 문법으로 그대로 옮긴 함수
fun maxV1(a: Int, b: Int): Int {
	if (a > b) {
		return a
	} else {
		return b
	}
}

// 코틀린에서 함수는 expression이란 개념 활용
fun maxV2(a: Int, b: Int): Int {
	return if (a > b) {
		a
	} else {
		b
	}
}

// 함수가 하나의 결과값이면 block 대신 = 사용 가능
fun maxV3(a: Int, b: Int): Int = if (a > b) { a } else { b }

// 중괄호 생략 가능
fun maxV4(a: Int, b: Int): Int = if (a > b) a else b

// block { }을 사용하는 경우에는 반환타입이 Unit이 아니면 반환타입을 명시적으로 작성해야함

fun repeat(str: String, num: Int, useNewLine: Boolean) {
	for (i in 0 until num) {
		if (useNewLine) {
			println(str)
		} else {
			print("${str} ")
		}
	}
}

fun repeat(str: String, num: Int) {
	repeat(str, num, true)
}

fun repeat(str: String) {
	repeat(str, 3, true)
}

fun repeatWithDefault(
	str: String,
	num: Int = 3,
	useNewLine: Boolean = true
) {
	for (i in 0 until num) {
		if (useNewLine) {
			println(str)
		} else {
			print("${str} ")
		}
	}
}

fun printNameAndGender(name: String, gender: String) {
	println(name)
	println(gender)
}

// java : String... strings 형태로 선언, 입력하는 쪽에서는 배열이나 , 사용해서 입력
// kotlin : varargs 형태로 선언, 입력하는 쪽에서는 배열이나 , 사용해서 입력하는 것은 유사한데 배열을 넘길때 변수명 앞에 * 붙여야함
fun printAll(vararg strings: String) {
	for (str in strings) {
		println(str)
	}
}