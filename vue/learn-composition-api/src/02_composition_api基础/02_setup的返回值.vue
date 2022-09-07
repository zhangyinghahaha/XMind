<template>
    <div>
        Home Page
        <h2>{{ message }}</h2>
        
        <h2>{{title}}</h2>
        <!-- 当我们在template中使用ref对象，它会自动解包 -->
        <h2>{{counter}}</h2>
        <button @click="increment">+1</button>
    </div>
</template>

<script>
    import {reactive, ref} from 'vue';
    export default {
        props: {
            message: {
                type: String,
                required: true
            },
        },
        data() {
            return {
                counter: 0
            }
        },
        setup(props, context) {
            // reactive api
            // const state = reactive({
            //     counter: 100,
            //     title: "reactive api title"
            // })

            // ref api
            let counter = ref(100);
            
            const increment = () => {
                // ref api具体之存储在value属性中
                counter.value++;
            };

            return {counter, increment};
        },
    }
</script>

<style lang="scss" scoped>

</style>