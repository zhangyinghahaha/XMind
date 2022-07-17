<template>
    <div>
        <TabControl :titles="titles" @titleChange="titleChange"></TabControl>

        <ul>
            <li v-for="item in content[currentIndex]" :key="item.id">
                {{ item }}
            </li>
        </ul>
    </div>
</template>

<script>
import TabControl from "./TabControl.vue";
export default {
    components: { TabControl },
    data() {
        return {
            titles: ["衣服", "鞋子", "帽子"],
            content: [
                ["衣服1", "衣服2", "衣服3"],
                ["鞋子", "鞋子2", "鞋子3"],
                ["帽子1", "帽子2", "帽子3"],
            ],
            currentIndex: 0,
        };
    },
    methods: {
        titleChange(index) {
            this.currentIndex = index;
        },
    },
};
</script>

<style lang="scss" scoped></style>
