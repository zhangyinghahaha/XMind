<script setup>
import useCounterStore from '@/stores/counter';
import { storeToRefs } from 'pinia';

const counterStore = useCounterStore();

const { count } = storeToRefs(counterStore);
function increment() {
    count.value++;
}
</script>

<template>
    <div>
        <h2>Hello, Pinia!</h2>
        <p>count: {{count}}</p>
        <button @click="increment">+1</button>
    </div>
</template>

<style scoped>

</style>