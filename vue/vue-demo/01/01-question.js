// js 对象this理解
// this就出现了，它的设计目的就是在函数体内部，指代函数当前的运行环境

// 箭头函数this有什么不同？
// 箭头函数根本没有自己的this，内部的this就是使用外层代码块的this


var sayHello = function () {
	console.log(this);
	console.log('hello ' + this.name)
}

function Person(name, age) {
	this.name = name
	this.age = age
	// this.type = 'human'
	// this.sayHello = sayHello
}

console.log('--prototype--');
console.log(Person.prototype);
console.log(Person.prototype.constructor);
var human = {
	this: this,
	type: 'human',
	sayHello: sayHello
}
console.log(human.this);
Person.prototype = human;
console.log(Person.prototype);
console.log(Person.prototype.constructor);

var p1 = new Person('Top', 18);
var p2 = Object.create(p1);

console.log('--object p1--');
p1.sayHello();
console.log(p1.constructor);
console.log(p1.__proto__);
console.log(p1.type);

console.log('--change prototype--');
Person.prototype.type = 'human2';

p2.sayHello();
console.log(p2.constructor);
console.log(p2.__proto__)
console.log(p2.type);
console.log(p2.__proto__)

console.log('-----');
var internal = 2;
var o = {
	f1: function () {
		console.log(this);
		var internal = 1;
		// 匿名函数
		// var f2 = function () {
		// 	console.log(this);
		// };
		// 箭头函数
		// var f2 = () => {
		// 	console.log(this);
		// };
		// 普通函数
		function f2() {
			// console.log(this);
			// console.log(this.internal);
		}
		f2.call();
	},
	f2: () => {
		console.log(this);
	}
}

o.f1()
console.log('f2');
console.log(this);
o.f2();



// ES5只有两种作用域: 全局作用域 函数作用域
// ES6补充了块级作用域
