<div id="disqus_thread"></div>
<script>

    var disqus_config = function () {
        this.page.url = "${url}";
        this.page.identifier = "${identifier}";

        <g:if test="${title}">
            this.page.title = "${title}";
        </g:if>

        <g:if test="${category}">
            this.page.category_id = "${category}";
        </g:if>
    };

    (function () {
        var d = document, s = d.createElement('script');

        s.src = 'https://${shortname}.disqus.com/embed.js';

        s.setAttribute('data-timestamp', +new Date());
        (d.head || d.body).appendChild(s);
    })();
</script>
<g:if test="${noscript}">
    <noscript>${noscript}</noscript>
</g:if>
<g:if test="${powered}">
    <a href="https://disqus.com/?ref_noscript" rel="nofollow">comments powered by Disqus.</a></noscript>
</g:if>
