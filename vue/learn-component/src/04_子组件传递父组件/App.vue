<template>
    <div>
        <h2>当前计数: {{ counter }}</h2>
        <CounterOps @add="add" @sub="sub" @addAny="addAny"></CounterOps>
    </div>
</template>

<script>
import CounterOps from "./CounterOps.vue";
export default {
    data() {
        return {
            counter: 0,
        };
    },
    components: { CounterOps },
    methods: {
        add() {
            this.counter++;
        },
        sub() {
            this.counter--;
        },
        addAny(num) {
            this.counter += num;
        }
    },
};
</script>

<style lang="scss" scoped></style>
