<template>
    <div>
        <Home></Home>
        <button @click="addName">Add Name</button>
    </div>
</template>

<script>
import Home from "./Home.vue";
import { computed } from 'vue';
export default {
    components: { Home },
    provide() {
        console.log(this);
        return {
            name: "why",
            age: 18,
            length: computed(() => this.names.length),
        };
    },
    data() {
        return {
            names: ["a", "b", "c"],
        };
    },
    methods: {
        addName() {
            this.names.push('a');
            console.log(this.names);
        }
    },
};
</script>

<style lang="scss" scoped></style>
