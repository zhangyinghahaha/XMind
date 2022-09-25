<template>
    <div>
        <h2>{{name}}</h2>
        <h2>{{counter}}</h2>

        <button @click="increment">home+1</button>
    </div>
</template>

<script>
import {inject} from 'vue';

export default {
    
    setup () {
        const name = inject('name');
        // 违背单项数据流原则
        const counter = inject('counter');

        const increment = () => counter.value++;

        return {
            name,
            counter,
            increment
        };
    }
}
</script>

<style lang="scss" scoped>

</style>