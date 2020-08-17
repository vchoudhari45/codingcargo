<h1>Pages</h1>
<blockquote>
	<p>This document is for Next.js versions 9.3 and up. If you're using older versions of Next.js, refer to our <a href="/docs/tag/v9.2.2/basic-features/pages" class="relative">previous documentation</a>.</p>
</blockquote>
<p>In Next.js, a <strong>page</strong> is a <a href="https://reactjs.org/docs/components-and-props.html" class="absolute" target="_blank" rel="noopener noreferrer">React Component</a> exported from a <code class="inline">.js</code>, <code class="inline">.jsx</code>, <code class="inline">.ts</code>, or <code class="inline">.tsx</code> file in the <code class="inline">pages</code> directory. Each page is associated with a route based on its file name.</p>
<p><strong>Example</strong>: If you create <code class="inline">pages/about.js</code> that exports a React component like below, it will be accessible at <code class="inline">/about</code>.</p>


<h3 class="heading">
		<a href="#pages-with-dynamic-routes">Pages with Dynamic Routes</a>
</h3>
<p>Next.js supports pages with dynamic routes. For example, if you create a file called <code class="inline">pages/posts/[id].js</code>, then it will be accessible at <code class="inline">posts/1</code>, <code class="inline">posts/2</code>, etc.</p>
<blockquote>
	<p>To learn more about dynamic routing, check the <a href="/docs/routing/dynamic-routes" class="relative">Dynamic Routing documentation</a>.</p>
</blockquote>


<h2 class="heading">
    <a href="#pre-rendering">Pre-rendering</a>
</h2>
<p>By default, Next.js <strong>pre-renders</strong> every page. This means that Next.js generates HTML for each page in advance, instead of having it all done by client-side JavaScript. Pre-rendering can result in better performance and SEO.</p>
<p>Each generated HTML is associated with minimal JavaScript code necessary for that page. When a page is loaded by the browser, its JavaScript code runs and makes the page fully interactive. (This process is called <em>hydration</em>.)</p>


<h3 class="heading">
    <span id="two-forms-of-pre-rendering"></span>
    <a href="#two-forms-of-pre-rendering">Two forms of Pre-rendering</a>
</h3>
<p>Next.js has two forms of pre-rendering: <strong>Static Generation</strong> and <strong>Server-side Rendering</strong>. The difference is in <strong>when</strong> it generates the HTML for a page.</p>
<ul>
    <li>
        <a href="#static-generation-recommended" class="relative">
            <strong>Static Generation (Recommended)</strong>
        </a>: The HTML is generated at <strong>build time</strong> and will be reused on each request.
    </li>
    <li>
        <a href="#server-side-rendering" class="relative">
        <strong>Server-side Rendering</strong>
        </a>: The HTML is generated on <strong>each request</strong>.
    </li>
</ul>
<p>Importantly, Next.js lets you <strong>choose</strong> which pre-rendering form you'd like to use for each page. You can create a "hybrid" Next.js app by using Static Generation for most pages and using Server-side Rendering for others.</p>
<p>We <strong>recommend</strong> using <strong>Static Generation</strong> over Server-side Rendering for performance reasons. Statically generated pages can be cached by CDN with no extra configuration to boost performance. However, in some cases, Server-side Rendering might be the only option.</p>
<p>You can also use <strong>Client-side Rendering</strong> along with Static Generation or Server-side Rendering. That means some parts of a page can be rendered entirely by client side JavaScript. To learn more, take a look at the <a href="/docs/basic-features/data-fetching#fetching-data-on-the-client-side" class="relative">Data Fetching</a> documentation.</p>


<h2 class="heading">
    <span id="static-generation-recommended"></span>
        <a href="#static-generation-recommended">Static Generation (Recommended)</a>
</h2>
<details open>
    <summary>
        <b>Examples</b>
    </summary>
    <ul>
        <li><a href="https://github.com/vercel/next.js/tree/canary/examples/cms-wordpress" class="absolute" target="_blank" rel="noopener noreferrer">WordPress Example</a> (<a href="https://next-blog-wordpress.now.sh" class="absolute" target="_blank" rel="noopener noreferrer">Demo</a>)</li>
        <li><a href="https://github.com/vercel/next.js/tree/canary/examples/blog-starter" class="absolute" target="_blank" rel="noopener noreferrer">Blog Starter using markdown files</a> (<a href="https://next-blog-starter.now.sh/" class="absolute" target="_blank" rel="noopener noreferrer">Demo</a>)</li>
        <li><a href="https://github.com/vercel/next.js/tree/canary/examples/cms-datocms" class="absolute" target="_blank" rel="noopener noreferrer">DatoCMS Example</a> (<a href="https://next-blog-datocms.now.sh/" class="absolute" target="_blank" rel="noopener noreferrer">Demo</a>)</li>
        <li><a href="https://github.com/vercel/next.js/tree/canary/examples/cms-takeshape" class="absolute" target="_blank" rel="noopener noreferrer">TakeShape Example</a> (<a href="https://next-blog-takeshape.now.sh/" class="absolute" target="_blank" rel="noopener noreferrer">Demo</a>)</li>
        <li><a href="https://github.com/vercel/next.js/tree/canary/examples/cms-sanity" class="absolute" target="_blank" rel="noopener noreferrer">Sanity Example</a> (<a href="https://next-blog-sanity.now.sh/" class="absolute" target="_blank" rel="noopener noreferrer">Demo</a>)</li>
        <li><a href="https://github.com/vercel/next.js/tree/canary/examples/cms-prismic" class="absolute" target="_blank" rel="noopener noreferrer">Prismic Example</a> (<a href="https://next-blog-prismic.now.sh/" class="absolute" target="_blank" rel="noopener noreferrer">Demo</a>)</li>
        <li><a href="https://github.com/vercel/next.js/tree/canary/examples/cms-contentful" class="absolute" target="_blank" rel="noopener noreferrer">Contentful Example</a> (<a href="https://next-blog-contentful.now.sh/" class="absolute" target="_blank" rel="noopener noreferrer">Demo</a>)</li>
        <li><a href="https://github.com/vercel/next.js/tree/canary/examples/cms-strapi" class="absolute" target="_blank" rel="noopener noreferrer">Strapi Example</a> (<a href="https://next-blog-strapi.now.sh/" class="absolute" target="_blank" rel="noopener noreferrer">Demo</a>)</li>
        <li><a href="https://github.com/vercel/next.js/tree/canary/examples/cms-agilitycms" class="absolute" target="_blank" rel="noopener noreferrer">Agility CMS Example</a> (<a href="https://next-blog-agilitycms.now.sh/" class="absolute" target="_blank" rel="noopener noreferrer">Demo</a>)</li>
        <li><a href="https://github.com/vercel/next.js/tree/canary/examples/cms-cosmic" class="absolute" target="_blank" rel="noopener noreferrer">Cosmic Example</a> (<a href="https://next-blog-cosmic.now.sh/" class="absolute" target="_blank" rel="noopener noreferrer">Demo</a>)</li>
        <li><a href="https://github.com/vercel/next.js/tree/canary/examples/cms-buttercms" class="absolute" target="_blank" rel="noopener noreferrer">ButterCMS Example</a> (<a href="https://next-blog-buttercms.now.sh/" class="absolute" target="_blank" rel="noopener noreferrer">Demo</a>)</li>
        <li><a href="https://github.com/vercel/next.js/tree/canary/examples/cms-storyblok" class="absolute" target="_blank" rel="noopener noreferrer">Storyblok Example</a> (<a href="https://next-blog-storyblok.now.sh/" class="absolute" target="_blank" rel="noopener noreferrer">Demo</a>)</li>
        <li><a href="https://github.com/vercel/next.js/tree/canary/examples/cms-graphcms" class="absolute" target="_blank" rel="noopener noreferrer">GraphCMS Example</a> (<a href="https://next-blog-graphcms.now.sh/" class="absolute" target="_blank" rel="noopener noreferrer">Demo</a>)</li>
        <li><a href="https://static-tweet.now.sh/" class="absolute" target="_blank" rel="noopener noreferrer">Static Tweet Demo</a></li>
    </ul>
</details>
<p>If a page uses <strong>Static Generation</strong>, the page HTML is generated at <strong>build time</strong>. That means in production, the page HTML is generated when you run <code class="inline">next build</code> . This HTML will then be reused on each request. It can be cached by a CDN.</p>
<p>In Next.js, you can statically generate pages <strong>with or without data</strong>. Let's take a look at each case.</p>



<h2 class="heading">
    <span id="summary"></span>
        <a href="#summary">Summary</a>
</h2>
<p>We've discussed two forms of pre-rendering for Next.js.</p>
<ul>
    <li><strong>Static Generation (Recommended):</strong> The HTML is generated at <strong>build time</strong> and will be reused on each request. To make a page use Static Generation, either export the page component, or export <code class="inline">getStaticProps</code> (and <code class="inline">getStaticPaths</code> if necessary). It's great for pages that can be pre-rendered ahead of a user's request. You can also use it with Client-side Rendering to bring in additional data.</li>
    <li><strong>Server-side Rendering:</strong> The HTML is generated on <strong>each request</strong>. To make a page use Server-side Rendering, export <code class="inline">getServerSideProps</code>. Because Server-side Rendering results in slower performance than Static Generation, use this only if absolutely necessary.</li>
</ul>


<h2 class="heading">
    <span id="learn-more"></span>
    <a href="#learn-more">Learn more</a>
</h2>
<p>We recommend you to read the following sections next:</p>


<div class="card">
    <a href="/docs/basic-features/data-fetching" class="relative">
        <h4>Data Fetching</h4>
        <small>Learn more about data fetching in Next.js.</small>
    </a>
</div>

<div class="card">
    <a href="/docs/advanced-features/preview-mode" class="relative">
        <h4>Preview Mode</h4>
        <small>Learn more about the preview mode in Next.js.</small>
    </a>
</div>    
