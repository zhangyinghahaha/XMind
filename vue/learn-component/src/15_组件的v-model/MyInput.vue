<template>
    <div>
        <!-- <button @click="btnClick">自定义事件</button> -->
        <input v-model="inputString" type="text" />
    </div>
</template>

<script>
    export default {
        props: {
            modelValue: {
                type: String,
                default: ''
            },
        },
        methods: {
            btnClick() {
                this.$emit('update:modelValue', 'hahaha');
            }
        },
        emits: ['update:modelValue'],
        computed: {
            inputString: {
                set(value) {
                    this.$emit('update:modelValue', value);
                },
                get() {
                    return this.modelValue;
                }
            }
        },
    }
</script>

<style lang="scss" scoped>

</style>