<script setup>
defineProps({
    title: {
        type: String,
        default: '默认标题'
    },
    subTitle: {
        type: String,
        default: '默认子标题'
    }
})
</script>

<template>
    <div class="area-header">
        <div class="title">{{ title }}</div>
        <div class="subTitle">{{ subTitle }}</div>
    </div>
</template>

<style lang="less" scoped>
.area-header {
    height: 84px;

    .title {
        font-size: 22px;
    }

    .subtitle {
        margin-top: 12px;
        font-size: 16px;
    }
}
</style>
