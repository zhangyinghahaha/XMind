<script setup>
import useCounterStore from '@/stores/counter';
import { storeToRefs } from 'pinia';
import useUserStore from '@/stores/user';

const counterStore = useCounterStore();
const { count, doubleCount, doubleAddOne, unionOtherStore } = storeToRefs(counterStore);
function increment() {
    count.value++;
}

const userStore = useUserStore();
const { name, age } = storeToRefs(userStore);
function changeUserState() {
    // name.value = 'zhang san';
    // age.value = 26;

    userStore.$patch({name: 'zhang san', age: 100});
}
function resetUserState() {
    userStore.$reset();
}
</script>

<template>
    <div>
        <h2>Hello, Pinia!</h2>

        <h3>Counter Store</h3>
        <p>count: {{count}}</p>
        <p>double count: {{doubleCount}}</p>
        <p>double add one: {{doubleAddOne}}</p>
        <p>union other store: {{unionOtherStore}}</p>
        <button @click="increment">+1</button>


        <h3>User Store</h3>
        <p>{{name}} {{age}}</p>
        <button @click="changeUserState">修改state</button>
        <button @click="resetUserState">重置state</button>
    </div>
</template>

<style scoped>

</style>