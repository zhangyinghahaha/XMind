<template>
    <div>
        <!-- <input v-model="message" type="text" /> -->
        <h2>{{ title }}</h2>
        <h2>{{ message }}</h2>

        <!-- v-model绑定自定义组件 -->
        <MyInput v-model="message" v-model:title="title"></MyInput>
        <!-- <MyInput :modelValue="message" @update:model-value="message = $event"></MyInput> -->
    </div>
</template>

<script>
import MyInput from "./MyInput.vue";
export default {
    data() {
        return {
            message: "hello world",
            title: "My Title"
        };
    },
    components: { MyInput },
};
</script>

<style lang="scss" scoped></style>
