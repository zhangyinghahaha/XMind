<template>
    <div>
        <h2>{{title}}</h2>
        <h2>{{message}}</h2>

        <hello-world></hello-world>
    </div>
</template>

<script>
import HelloWorld from './HelloWorld.vue';
    export default {
        components: {
            HelloWorld
        },
        data() {
            return {
                title: 'vue 起步',
                message: 'hello vue',
            }
        },
    }
</script>

<style scoped>
h2 {
    color: red;
}
</style>