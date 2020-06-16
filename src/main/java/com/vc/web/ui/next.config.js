// On production, variables are set with `now secrets`. On development, they use the .env file
require('dotenv').config();
module.exports = {
  theme: {
    colors: {
      lightWhite: '#f8f8f2',
    }
  },
  //https://nextjs.org/docs/api-reference/next.config.js/exportPathMap
  //https://nextjs.org/docs/advanced-features/static-html-export
  // exportPathMap: async function (defaultPathMap, { dev, dir, outDir, distDir, buildId }) {
  //   console.log(defaultPathMap)
  //   console.log(dev)
  //   console.log(dir)
  //   console.log(outDir)
  //   console.log(distDir)
  //   console.log(buildId)
  //   return {
	// 	  "/" : { page: '/' },
	// 	  "/index" : { page: '/index' },
	// 	  "/404" : { page: '/404' },
	// 	  "/list/data-structures-and-algorithms" : { page: '/list/[category]' },
	// 	  "/list/data-structures-and-algorithms/amazon" : { page: '/list/[category]/[tag]' },
	// 	  "/list/data-structures-and-algorithms/amazon/1" : { page: '/list/[category]/[tag]/[page]' },
	// 	  "/list/data-structures-and-algorithms/array" : { page: '/list/[category]/[tag]' },
	// 	  "/list/data-structures-and-algorithms/array/1" : { page: '/list/[category]/[tag]/[page]' },
	// 	  "/list/data-structures-and-algorithms/facebook" : { page: '/list/[category]/[tag]' },
	// 	  "/list/data-structures-and-algorithms/facebook/1" : { page: '/list/[category]/[tag]/[page]' },
	// 	  "/list/data-structures-and-algorithms/google" : { page: '/list/[category]/[tag]' },
	// 	  "/list/data-structures-and-algorithms/google/1" : { page: '/list/[category]/[tag]/[page]' },
	// 	  "/list/data-structures-and-algorithms/hash-table" : { page: '/list/[category]/[tag]' },
	// 	  "/list/data-structures-and-algorithms/hash-table/1" : { page: '/list/[category]/[tag]/[page]' },
	// 	  "/list/data-structures-and-algorithms/leetcode" : { page: '/list/[category]/[tag]' },
	// 	  "/list/data-structures-and-algorithms/leetcode/1" : { page: '/list/[category]/[tag]/[page]' },
	// 	  "/list/data-structures-and-algorithms/microsoft" : { page: '/list/[category]/[tag]' },
	// 	  "/list/data-structures-and-algorithms/microsoft/1" : { page: '/list/[category]/[tag]/[page]' },
	// 	  "/post/two-sum" : { page: '/post/[postTitle]' },
	//   }
  // },
  compress: true,
  exportTrailingSlash: true,
  env: {
    FIREBASE_API_KEY: process.env.FIREBASE_API_KEY,
    FIREBASE_AUTH_DOMAIN: process.env.FIREBASE_AUTH_DOMAIN,
    FIREBASE_DATABASE_URL: process.env.FIREBASE_DATABASE_URL,
    FIREBASE_PROJECT_ID: process.env.FIREBASE_PROJECT_ID,
    FIREBASE_STORAGE_BUCKET: process.env.FIREBASE_STORAGE_BUCKET,
    FIREBASE_MESSAGING_SENDER_ID: process.env.FIREBASE_MESSAGING_SENDER_ID,
    FIREBASE_APP_ID: process.env.FIREBASE_APP_ID,
    FIREBASE_MEASUREMENT_ID: process.env.FIREBASE_MEASUREMENT_ID
  },
  devIndicators: {
    autoPrerender: false,
  }
}
