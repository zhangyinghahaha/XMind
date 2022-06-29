const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const { DefinePlugin } = require('webpack');
const { VueLoaderPlugin } = require('vue-loader/dist/index');

module.exports = {
    target: 'web',
    // 在该模式下，webpack依赖图中的所有文件只要有一个发生了更新，那么代码将被重新编译
    // watch: true,
    entry: './src/main.js',
    output: {
        path: path.resolve(__dirname, '../build'),
        filename: 'js/bundle.js',
    },
    resolve: {
        alias: {
            // 路径别名
            '@': path.resolve(__dirname, '../src'),
        }
    },
    module: {
        rules: [
            {
                test: /\.css$/,
                // loader: 'css-loader'
                use: [
                    'style-loader',
                    'css-loader', 
                    {
                        loader: 'postcss-loader',
                        options: {
                            postcssOptions: {
                                plugins: [require('postcss-preset-env')]
                            }
                        }
                    }
                ]
            },
            {
                test: /\.less$/,
                // loader: 'css-loader'
                use: [
                    'style-loader',
                    'css-loader', 
                    'less-loader',
                ]
            },
            // {
            //     test: /\.(jpg|jpeg|png|gif|svg)$/,
            //     use: {
            //         loader: 'url-loader',
            //         options: {
            //             // outputPath: 'img',
            //             name: 'img/[name]_[hash:6].[ext]',
            //             limit: 100*1024
            //         }
            //     },
            // },
            {
                test: /\.(jpg|jpeg|png|gif|svg)$/,
                type: 'asset',
                generator: {
                    filename: 'image/[name]_[hash:6][ext]',
                },
                parser: {
                    dataUrlCondition: {
                        maxSize: 10*1024
                    }
                },
            },
            {
                test: /\.(eot|ttf|woff2?)$/,
                type: 'asset/resource',
                generator: {
                    filename: 'font/[name]_[hash:6][ext]',
                },
            },
            {
                test: /\.js$/,
                loader: 'babel-loader',
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            }
        ],
    },
    plugins: [
        new HtmlWebpackPlugin({
            title: 'webpack项目打包demo',
            template: './public/index.html',
        }),
        new DefinePlugin({
            BASE_URL: '"./"',
            __VUE_OPTIONS_API__: true,
            __VUE_PROD_DEVTOOLS__: true,
        }),
        new VueLoaderPlugin(),
    ],
}