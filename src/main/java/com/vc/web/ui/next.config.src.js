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
  exportPathMap: async function (defaultPathMap, { dev, dir, outDir, distDir, buildId }) {
    console.log(defaultPathMap)
    console.log(dev)
    console.log(dir)
    console.log(outDir)
    console.log(distDir)
    console.log(buildId)
    return '###NEXT_JS_EXPORT_MAPPING_PLACEHOLDER###'
  },
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
