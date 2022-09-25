<template>
    <div>
        <h2>App</h2>
        <button @click="increment">+1</button>
        <Home/>
    </div>
</template>

<script>
    import {provide, ref, readonly} from 'vue';
    import Home from './Home.vue';
    export default {
        components: {
            Home,
        },
        setup() {
            const name = 'zhang ying';
            let counter = ref(100);

            const increment = () => {counter.value++};

            provide('name', name);
            provide('counter', readonly(counter));

            return {
                increment
            };
        }
    }
</script>

<style lang="scss" scoped>

</style>