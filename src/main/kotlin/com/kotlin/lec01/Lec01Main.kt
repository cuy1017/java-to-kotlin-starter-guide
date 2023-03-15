package com.kotlin.lec01

fun main() {
	var number1: Long = 10L // 세미콜론 안씀
	number1 = 5L

//	val number2 = 10L
//	number2 = 5L // val 은 불변객체이기 때문에 변경 불가

	var number3: Long? = 10L // nullable 하게 하기 위해서 ? 추가
	number3 = null

	var person = Person("최윤연") // 객체 생성 시 new 붙이지 않음
}