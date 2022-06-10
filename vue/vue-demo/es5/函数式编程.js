// 函数式编程(Functional Programming)
// 1 范畴论(Category Theory)
// 范畴: 在数学中，范畴就是由箭头(态射)连接的对象组成的代数结构(对象 + 态射)
// 范畴论认为，同一个范畴的所有成员，就是不同状态的"变形"（transformation）。通过"态射"，一个成员可以变形成另一个成员。
// 范畴论与函数式编程的关系：范畴论使用函数，表达范畴之间的关系。
// 伴随着范畴论的发展，就发展出一整套函数的运算方法。这套方法起初只用于数学运算，后来有人将它在计算机上实现了，就变成了今天的"函数式编程"。

// 2 函数的基本运算
// 函数式编程有两个最基本的运算：合成和柯里化
// 合成compose
const compose = function(f, g) {
    return function(x) {
        return f(g(x));
    };
};
// 函数的合成必须满足结合律
compose(f, compose(g, h));
// 等同于
compose(compose(f, g), h);

// 柯里化:就是把一个多参数的函数，转化为单参数函数
function add(x, y) {
    return x + y;
}
add(1, 2);
// 柯里化后
function curry_add(x) {
    return function (y) {
        return x + y;
    }
}
curry_add(1)(2);

function curry(f, g) {}

// 3 函子(Functor)
// 函子就是一个范畴，包含了值和变形关系。特殊的是，包含一个map变形关系，改方法可以将范畴内的每个值，映射到另一个范畴。
class Functor {
    constructor(val) {
        this.val = val;
    }
    
    map(f) {
        return new Functor(f(this.val));
    }
}

let Container = function(x){this.__value = x;};
Container.of = function(x) {return new Container(x)};
Container.prototype.map = function(f) {
    return Container.of(f(this.__value));
}

let container1 = Container.of(3);

// 函数式编程深似海