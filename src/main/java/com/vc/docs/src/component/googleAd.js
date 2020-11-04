import React, { useEffect } from "react";

const GoogleAd = () => {
  useEffect(() => {
    (window.adsbygoogle = window.adsbygoogle || []).push({});
  }, []);

  return (
		<ins class="adsbygoogle"
             data-ad-client="ca-pub-5837843548871883"
             data-ad-slot="1405717915"
             data-ad-format="auto"
             inline-style="display:inline-block;width:100%;"
             data-full-width-responsive="true"></ins>
  );
};

export default GoogleAd;