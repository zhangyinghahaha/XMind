// Number类型
let n = 123;
console.log(n / 0);

// BigInt
const bigInt = 1234567891234569n;
console.log(typeof bigInt);

debugger;

// String
let str = 'zhang';
let str2 = "zhang";
let str3 = `zhang ${str}`;
console.log(str, str2, str3);

// Boolean
let checked = true;

// null
// null 不指代空指针，而是代表nothing, empty or value unknown
let age = null;
console.log(age);

// undefined 代表 变量已被声明，但未被赋值,常用于为初始化变量的初始值
let undef;
console.log(undef);

let user = 'zhang ying';
console.log(user ?? '匿名');

// Object, Symbol
