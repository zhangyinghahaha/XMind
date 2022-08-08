<template>
    <div>
        <!-- <input v-model="message" type="text" /> -->
        <h2>{{ message }}</h2>

        <!-- v-model绑定自定义组件 -->
        <MyInput v-model="message"></MyInput>
    </div>
</template>

<script>
import MyInput from "./MyInput.vue";
export default {
    data() {
        return {
            message: "hello world",
        };
    },
    components: { MyInput },
};
</script>

<style lang="scss" scoped></style>
