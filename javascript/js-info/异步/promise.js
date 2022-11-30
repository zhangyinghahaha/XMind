let promise = new Promise((resolve, reject) => {
    console.log('executor start:');
    // reject(new Error('I am error'));
    // throw new Error('I am error');
    // resolve('hahaha');

    setTimeout(() => {
        resolve('hahaha');
        console.log('executor done!');
        debugger;
    }, 10000);
    debugger;
}).then((result) => {
    console.log(result);  
}).then((result) => {
    console.log(result);  
}).then((result) => {
    console.log(result);  
});
// .catch((err) => {
//     console.log(err.message);
// }).finally((result) => {
//     console.log(result); 
//     console.log('Promise Finally!');
// });

console.log('我是主流程');
console.log(promise);

debugger;

async function promise() {
    console.log('promise start');
    return 1;
}
promise();
console.log('a');

let a = promise().then((result) => {
    console.log(result);
}).catch((err) => {
    console.log(err);
});;
console.log(a);

console.log(1);
let result = fetch('https://baidu.com');
console.log(2);
