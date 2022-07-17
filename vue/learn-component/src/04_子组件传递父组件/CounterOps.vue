<template>
    <div>
        <button @click="increment">+1</button>
        <button @click="decrement">-1</button>
        <input v-model.number="num" type="number" step="1" />
        <button @click="addAny">+n</button>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                num: 0
            }
        },
        methods: {
            increment() {
                console.log('+1');
                this.$emit('add');
            },
            decrement() {
                console.log('-1');
                this.$emit('sub');
            },
            addAny() {
                this.$emit('addAny', this.num);
            }
        },
        // emits: ['add', 'sub', 'addAny']
        emits: {
            add: null,
            sub: null,
            addAny: payload => {
                console.log(payload);
                if (payload < 10) {
                    return false;
                }
                return true;
            }
        }
    }
</script>

<style lang="scss" scoped>

</style>