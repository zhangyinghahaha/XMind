<script setup>
defineProps({
    item: {
        type: Object,
        default: () => ({})
    }
});
</script>

<template>
    <div class="room-item">
        <div class="item-inner">
            <div class="cover">
                <img :src="item.picture_url" alt="" />
            </div>
            <div class="info">
                <div class="title">
                    {{ "TODO" }}
                </div>
                <div class="name">
                    {{ item.name }}
                </div>
                <div class="price">
                    {{ item.price_format + "/晚" }}
                </div>
                <div class="bottom-info">
                    {{ item.bottom_info.content }}
                </div>
            </div>
        </div>
    </div>
</template>

<style lang="less" scoped>
.room-item {
    width: 33.333333%;

    .item-inner {
        margin: 0 8px 12px;
        color: #484848;
        font-weight: 800;

        img {
            width: 100%;
            border-radius: 3px;
        }

        .info {
            .title {
                margin-top: 8px;
                font-size: 12px;
            }

            .name {
                margin-top: 3px;
                font-size: 16px;

                overflow: hidden;
                text-overflow: ellipsis;
                display: -webkit-box;
                -webkit-line-clamp: 2;
                -webkit-box-orient: vertical;
            }

            .price {
                margin: 3px 0;
                font-size: 14px;
                font-weight: 400;
            }
        }
    }
}
</style>
