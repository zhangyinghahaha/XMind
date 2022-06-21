const path = require('path');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const { DefinePlugin } = require('webpack');
const CopyWebpackPlugin = require('copy-webpack-plugin');

module.exports = {
    // 设置webpack打包模式: development/production
    mode: 'development',
    // 建立js映射文件，方便开发调试
    devtool: 'source-map',
    entry: './src/main.js',
    output: {
        path: path.resolve(__dirname, './build'),
        filename: 'js/bundle.js',
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
            }
        ],
    },
    plugins: [
        new CleanWebpackPlugin(),
        new HtmlWebpackPlugin({
            title: 'webpack项目打包demo',
            template: './public/index.html',
        }),
        new DefinePlugin({
            BASE_URL: '"./"',
        }),
        new CopyWebpackPlugin({
            patterns: [
                {
                    from: 'public',
                    to: './',
                    globOptions: {
                        ignore: ['**/index.html']
                    }
                },
            ]
        }),
    ],
}