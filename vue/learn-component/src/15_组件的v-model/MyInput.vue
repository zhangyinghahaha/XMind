<template>
    <div>
        <!-- <button @click="btnClick">自定义事件</button> -->
        <input v-model="inputTitle" type="text" />
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
            title: String
        },
        methods: {
            btnClick() {
                this.$emit('update:modelValue', 'hahaha');
            }
        },
        emits: ['update:modelValue', 'update:title'],
        computed: {
            inputString: {
                set(value) {
                    this.$emit('update:modelValue', value);
                },
                get() {
                    return this.modelValue;
                }
            },
            inputTitle: {
                set(value) {
                    this.$emit('update:title', value);
                },
                get() {
                    return this.title;
                }
            }
        },
    }
</script>

<style lang="scss" scoped>

</style>