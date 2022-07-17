<template>
    <div>
        <ShowMessage :title="title" :content="content"></ShowMessage>
        <ShowMessage :="message"></ShowMessage>
        <ShowMessage :content="content" name="zhang ying" id="1234567"></ShowMessage>
    </div>
</template>

<script>
import ShowMessage from "./ShowMessage.vue";
export default {
    components: { ShowMessage },
    data() {
        return {
            title: "一句话日记",
            content: '今天天气真好呀',
            message: {
                title: "一句话日记",
                content: '今天天气真好呀',
            }
        }
    },
};
</script>

<style scoped></style>
