<script setup>
import AreaHeader from "./AreaHeader.vue";
import RoomItem from "./RoomItem.vue";

defineProps({
    areaData: {
        type: Object,
        default: () => ({})
    }
});
</script>

<template>
    <div class="room-area">
        <AreaHeader
            :title="areaData.title"
            :sub-title="areaData.subtitle"
        ></AreaHeader>

        <div class="room-list">
            <template v-for="item in areaData.list" :key="item.id">
                <RoomItem :item="item"></RoomItem>
            </template>
        </div>
    </div>
</template>

<style lang="less" scoped>
.room-list {
    display: flex;
    flex-wrap: wrap;
    margin: 20px -8px;
}
</style>
