const app = Vue.createApp({
    template: "#demo",
    data() {
        return {
            books: [
                {
                    id: 1,
                    name: "《算法导论》",
                    date: "2006-9",
                    price: 85.0,
                    count: 1,
                },
                {
                    id: 2,
                     name: "《UNIX编程艺术》",
                    date: "2006-2",
                    price: 59.0,
                    count: 1,
                },
                {
                    id: 3,
                    name: "《编程珠玑》",
                    date: "2008-10",
                    price: 39.0,
                    count: 1,
                },
                {
                    id: 4,
                    name: "《代码大全》",
                    date: "2006-3",
                    price: 128.0,
                    count: 1,
                },
            ],
        };
    },
    methods: {
        increment(book) {
            book.count += 1;
        },
        decrement(book) {
            if (book.count <= 1) {
                return;
            } 
            book.count -= 1;
        },
        removeBook(book) {
            let removeIndex = this.books.findIndex((value) => value.id === book.id);
            this.books.splice(removeIndex, 1);
        },
        formatPrice(price) {
            return '¥' + price;
        }
    },
    computed: {
        totalPrice() {
            let total = 0;
            this.books.forEach(book => total += book.price * book.count);
            return this.formatPrice(total);
        },
        // vue3不支持过滤器,推荐两种替代方法: 1.计算属性; 2. 全局方法
        displayBooks() {
            return this.books.map(item => {
                let displayBook = {...item};
                displayBook.price = '¥' + displayBook.price;
                return displayBook;
            });
        },
    },
});
app.mount("#app");
