export const demoMixin = {
    data() {
        return {
            message: "hello mixin"
        }
    },
    methods: {
        foo() {
            console.log('hello mixin foo');
        }
    },
    created () {
        console.log('mixin created.');;
    },
}