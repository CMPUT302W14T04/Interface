




<!DOCTYPE html>
<html>
  <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# object: http://ogp.me/ns/object# article: http://ogp.me/ns/article# profile: http://ogp.me/ns/profile#">
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    
    <title>Interface/2wiiSoftware/src/wiiusej/test/WiiuseJGuiTest.java at 3f5b7764a8bb686f96f82fa28cab658614ef3168 · CMPUT302W14T04/Interface</title>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub" />
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub" />
    <link rel="apple-touch-icon" sizes="57x57" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="/apple-touch-icon-144.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="/apple-touch-icon-144.png" />
    <meta property="fb:app_id" content="1401488693436528"/>

      <meta content="@github" name="twitter:site" /><meta content="summary" name="twitter:card" /><meta content="CMPUT302W14T04/Interface" name="twitter:title" /><meta content="Interface - Repo for team project" name="twitter:description" /><meta content="https://identicons.github.com/a16d9213029774b916645436e686da60.png" name="twitter:image:src" />
<meta content="GitHub" property="og:site_name" /><meta content="object" property="og:type" /><meta content="https://identicons.github.com/a16d9213029774b916645436e686da60.png" property="og:image" /><meta content="CMPUT302W14T04/Interface" property="og:title" /><meta content="https://github.com/CMPUT302W14T04/Interface" property="og:url" /><meta content="Interface - Repo for team project" property="og:description" />

    <link rel="assets" href="https://github.global.ssl.fastly.net/">
    <link rel="conduit-xhr" href="https://ghconduit.com:25035/">
    <link rel="xhr-socket" href="/_sockets" />


    <meta name="msapplication-TileImage" content="/windows-tile.png" />
    <meta name="msapplication-TileColor" content="#ffffff" />
    <meta name="selected-link" value="repo_source" data-pjax-transient />
    <meta content="collector.githubapp.com" name="octolytics-host" /><meta content="collector-cdn.github.com" name="octolytics-script-host" /><meta content="github" name="octolytics-app-id" /><meta content="C649B206:4909:21CC8A5:5325E383" name="octolytics-dimension-request_id" /><meta content="5565737" name="octolytics-actor-id" /><meta content="jcadek" name="octolytics-actor-login" /><meta content="07aa6eae9566c0e87394d0d63df0c316bfe08241564c3748ff553d06e1333f64" name="octolytics-actor-hash" />
    

    
    
    <link rel="icon" type="image/x-icon" href="https://github.global.ssl.fastly.net/favicon.ico" />

    <meta content="authenticity_token" name="csrf-param" />
<meta content="nYF8rbCl0d2Qugt9YhkND+0MbgRopU2w8Fy5+0iHIDQ=" name="csrf-token" />

    <link href="https://github.global.ssl.fastly.net/assets/github-d9c478ed7e87eebc36430a1efc4e84b17e65df06.css" media="all" rel="stylesheet" type="text/css" />
    <link href="https://github.global.ssl.fastly.net/assets/github2-1f57c0abc60be1b966fe0cdd45e4a656a8f8a469.css" media="all" rel="stylesheet" type="text/css" />
    


      <script crossorigin="anonymous" src="https://github.global.ssl.fastly.net/assets/frameworks-55976bc637c425207bc6e52d7ac4c125773713de.js" type="text/javascript"></script>
      <script async="async" crossorigin="anonymous" src="https://github.global.ssl.fastly.net/assets/github-59c1229021d04ba714d869cf0ab18c2ff7a289ab.js" type="text/javascript"></script>
      
      <meta http-equiv="x-pjax-version" content="44c5c3cda0d9fbf11f6aacd6119c08a1">

        <link data-pjax-transient rel='permalink' href='/CMPUT302W14T04/Interface/blob/3f5b7764a8bb686f96f82fa28cab658614ef3168/2wiiSoftware/src/wiiusej/test/WiiuseJGuiTest.java'>

  <meta name="description" content="Interface - Repo for team project" />

  <meta content="6466031" name="octolytics-dimension-user_id" /><meta content="CMPUT302W14T04" name="octolytics-dimension-user_login" /><meta content="16123998" name="octolytics-dimension-repository_id" /><meta content="CMPUT302W14T04/Interface" name="octolytics-dimension-repository_nwo" /><meta content="true" name="octolytics-dimension-repository_public" /><meta content="false" name="octolytics-dimension-repository_is_fork" /><meta content="16123998" name="octolytics-dimension-repository_network_root_id" /><meta content="CMPUT302W14T04/Interface" name="octolytics-dimension-repository_network_root_nwo" />
  <link href="https://github.com/CMPUT302W14T04/Interface/commits/3f5b7764a8bb686f96f82fa28cab658614ef3168.atom" rel="alternate" title="Recent Commits to Interface:3f5b7764a8bb686f96f82fa28cab658614ef3168" type="application/atom+xml" />

  </head>


  <body class="logged_in  env-production windows vis-public page-blob">
    <a href="#start-of-content" class="accessibility-aid js-skip-to-content">Skip to content</a>
    <div class="wrapper">
      
      
      
      


      <div class="header header-logged-in true">
  <div class="container clearfix">

    <a class="header-logo-invertocat" href="https://github.com/">
  <span class="mega-octicon octicon-mark-github"></span>
</a>

    
    <a href="/notifications" aria-label="You have unread notifications" class="notification-indicator tooltipped tooltipped-s" data-gotokey="n">
        <span class="mail-status unread"></span>
</a>

      <div class="command-bar js-command-bar  in-repository">
          <form accept-charset="UTF-8" action="/search" class="command-bar-form" id="top_search_form" method="get">

<input type="text" data-hotkey="/ s" name="q" id="js-command-bar-field" placeholder="Search or type a command" tabindex="1" autocapitalize="off"
    
    data-username="jcadek"
      data-repo="CMPUT302W14T04/Interface"
      data-branch="3f5b7764a8bb686f96f82fa28cab658614ef3168"
      data-sha="a34e19f0f99191271ea5b0858e2c066e69929a50"
  >

    <input type="hidden" name="nwo" value="CMPUT302W14T04/Interface" />

    <div class="select-menu js-menu-container js-select-menu search-context-select-menu">
      <span class="minibutton select-menu-button js-menu-target" role="button" aria-haspopup="true">
        <span class="js-select-button">This repository</span>
      </span>

      <div class="select-menu-modal-holder js-menu-content js-navigation-container" aria-hidden="true">
        <div class="select-menu-modal">

          <div class="select-menu-item js-navigation-item js-this-repository-navigation-item selected">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" class="js-search-this-repository" name="search_target" value="repository" checked="checked" />
            <div class="select-menu-item-text js-select-button-text">This repository</div>
          </div> <!-- /.select-menu-item -->

          <div class="select-menu-item js-navigation-item js-all-repositories-navigation-item">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" name="search_target" value="global" />
            <div class="select-menu-item-text js-select-button-text">All repositories</div>
          </div> <!-- /.select-menu-item -->

        </div>
      </div>
    </div>

  <span class="help tooltipped tooltipped-s" aria-label="Show command bar help">
    <span class="octicon octicon-question"></span>
  </span>


  <input type="hidden" name="ref" value="cmdform">

</form>
        <ul class="top-nav">
          <li class="explore"><a href="/explore">Explore</a></li>
            <li><a href="https://gist.github.com">Gist</a></li>
            <li><a href="/blog">Blog</a></li>
          <li><a href="https://help.github.com">Help</a></li>
        </ul>
      </div>

    


  <ul id="user-links">
    <li>
      <a href="/jcadek" class="name">
        <img alt="jcadek" class=" js-avatar" data-user="5565737" height="20" src="https://avatars2.githubusercontent.com/u/5565737?s=140" width="20" /> jcadek
      </a>
    </li>

    <li class="new-menu dropdown-toggle js-menu-container">
      <a href="#" class="js-menu-target tooltipped tooltipped-s" aria-label="Create new...">
        <span class="octicon octicon-plus"></span>
        <span class="dropdown-arrow"></span>
      </a>

      <div class="new-menu-content js-menu-content">
      </div>
    </li>

    <li>
      <a href="/settings/profile" id="account_settings"
        class="tooltipped tooltipped-s"
        aria-label="Account settings ">
        <span class="octicon octicon-tools"></span>
      </a>
    </li>
    <li>
      <a class="tooltipped tooltipped-s" href="/logout" data-method="post" id="logout" aria-label="Sign out">
        <span class="octicon octicon-log-out"></span>
      </a>
    </li>

  </ul>

<div class="js-new-dropdown-contents hidden">
  

<ul class="dropdown-menu">
  <li>
    <a href="/new"><span class="octicon octicon-repo-create"></span> New repository</a>
  </li>
  <li>
    <a href="/organizations/new"><span class="octicon octicon-organization"></span> New organization</a>
  </li>
    <li class="section-title">
      <span title="CMPUT302W14T04">This organization</span>
    </li>

    <li>
      <a href="/orgs/CMPUT302W14T04/members/new"><span class="octicon octicon-person-add"></span> New member</a>
    </li>

    <li>
      <a href="/orgs/CMPUT302W14T04/new-team"><span class="octicon octicon-jersey"></span> New team</a>
    </li>

    <li>
      <a href="/organizations/CMPUT302W14T04/repositories/new"><span class="octicon octicon-repo-create"></span> New repository</a>
    </li>


    <li class="section-title">
      <span title="CMPUT302W14T04/Interface">This repository</span>
    </li>
      <li>
        <a href="/CMPUT302W14T04/Interface/issues/new"><span class="octicon octicon-issue-opened"></span> New issue</a>
      </li>
      <li>
        <a href="/CMPUT302W14T04/Interface/settings/collaboration"><span class="octicon octicon-person-add"></span> New collaborator</a>
      </li>
</ul>

</div>


    
  </div>
</div>

      

        



      <div id="start-of-content" class="accessibility-aid"></div>
          <div class="site" itemscope itemtype="http://schema.org/WebPage">
    
    <div class="pagehead repohead instapaper_ignore readability-menu">
      <div class="container">
        

<ul class="pagehead-actions">

    <li class="subscription">
      <form accept-charset="UTF-8" action="/notifications/subscribe" class="js-social-container" data-autosubmit="true" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="authenticity_token" type="hidden" value="nYF8rbCl0d2Qugt9YhkND+0MbgRopU2w8Fy5+0iHIDQ=" /></div>  <input id="repository_id" name="repository_id" type="hidden" value="16123998" />

    <div class="select-menu js-menu-container js-select-menu">
      <a class="social-count js-social-count" href="/CMPUT302W14T04/Interface/watchers">
        5
      </a>
      <span class="minibutton select-menu-button with-count js-menu-target" role="button" tabindex="0" aria-haspopup="true">
        <span class="js-select-button">
          <span class="octicon octicon-eye-unwatch"></span>
          Unwatch
        </span>
      </span>

      <div class="select-menu-modal-holder">
        <div class="select-menu-modal subscription-menu-modal js-menu-content" aria-hidden="true">
          <div class="select-menu-header">
            <span class="select-menu-title">Notification status</span>
            <span class="octicon octicon-remove-close js-menu-close"></span>
          </div> <!-- /.select-menu-header -->

          <div class="select-menu-list js-navigation-container" role="menu">

            <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input id="do_included" name="do" type="radio" value="included" />
                <h4>Not watching</h4>
                <span class="description">You only receive notifications for conversations in which you participate or are @mentioned.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-eye-watch"></span>
                  Watch
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

            <div class="select-menu-item js-navigation-item selected" role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input checked="checked" id="do_subscribed" name="do" type="radio" value="subscribed" />
                <h4>Watching</h4>
                <span class="description">You receive notifications for all conversations in this repository.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-eye-unwatch"></span>
                  Unwatch
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

            <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input id="do_ignore" name="do" type="radio" value="ignore" />
                <h4>Ignoring</h4>
                <span class="description">You do not receive any notifications for conversations in this repository.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-mute"></span>
                  Stop ignoring
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

          </div> <!-- /.select-menu-list -->

        </div> <!-- /.select-menu-modal -->
      </div> <!-- /.select-menu-modal-holder -->
    </div> <!-- /.select-menu -->

</form>
    </li>

  <li>
  

  <div class="js-toggler-container js-social-container starring-container ">
    <a href="/CMPUT302W14T04/Interface/unstar"
      class="minibutton with-count js-toggler-target star-button starred"
      aria-label="Unstar this repository" title="Unstar CMPUT302W14T04/Interface" data-remote="true" data-method="post" rel="nofollow">
      <span class="octicon octicon-star-delete"></span><span class="text">Unstar</span>
    </a>

    <a href="/CMPUT302W14T04/Interface/star"
      class="minibutton with-count js-toggler-target star-button unstarred"
      aria-label="Star this repository" title="Star CMPUT302W14T04/Interface" data-remote="true" data-method="post" rel="nofollow">
      <span class="octicon octicon-star"></span><span class="text">Star</span>
    </a>

      <a class="social-count js-social-count" href="/CMPUT302W14T04/Interface/stargazers">
        1
      </a>
  </div>

  </li>


        <li>
          <a href="/CMPUT302W14T04/Interface/fork" class="minibutton with-count js-toggler-target fork-button lighter tooltipped-n" title="Fork your own copy of CMPUT302W14T04/Interface to your account" aria-label="Fork your own copy of CMPUT302W14T04/Interface to your account" rel="facebox nofollow">
            <span class="octicon octicon-git-branch-create"></span><span class="text">Fork</span>
          </a>
          <a href="/CMPUT302W14T04/Interface/network" class="social-count">1</a>
        </li>


</ul>

        <h1 itemscope itemtype="http://data-vocabulary.org/Breadcrumb" class="entry-title public">
          <span class="repo-label"><span>public</span></span>
          <span class="mega-octicon octicon-repo"></span>
          <span class="author">
            <a href="/CMPUT302W14T04" class="url fn" itemprop="url" rel="author"><span itemprop="title">CMPUT302W14T04</span></a>
          </span>
          <span class="repohead-name-divider">/</span>
          <strong><a href="/CMPUT302W14T04/Interface" class="js-current-repository js-repo-home-link">Interface</a></strong>

          <span class="page-context-loader">
            <img alt="Octocat-spinner-32" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
          </span>

        </h1>
      </div><!-- /.container -->
    </div><!-- /.repohead -->

    <div class="container">
      <div class="repository-with-sidebar repo-container new-discussion-timeline js-new-discussion-timeline  ">
        <div class="repository-sidebar clearfix">
            

<div class="sunken-menu vertical-right repo-nav js-repo-nav js-repository-container-pjax js-octicon-loaders">
  <div class="sunken-menu-contents">
    <ul class="sunken-menu-group">
      <li class="tooltipped tooltipped-w" aria-label="Code">
        <a href="/CMPUT302W14T04/Interface" aria-label="Code" class="selected js-selected-navigation-item sunken-menu-item" data-gotokey="c" data-pjax="true" data-selected-links="repo_source repo_downloads repo_commits repo_tags repo_branches /CMPUT302W14T04/Interface">
          <span class="octicon octicon-code"></span> <span class="full-word">Code</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

        <li class="tooltipped tooltipped-w" aria-label="Issues">
          <a href="/CMPUT302W14T04/Interface/issues" aria-label="Issues" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-gotokey="i" data-selected-links="repo_issues /CMPUT302W14T04/Interface/issues">
            <span class="octicon octicon-issue-opened"></span> <span class="full-word">Issues</span>
            <span class='counter'>0</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>        </li>

      <li class="tooltipped tooltipped-w" aria-label="Pull Requests">
        <a href="/CMPUT302W14T04/Interface/pulls" aria-label="Pull Requests" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-gotokey="p" data-selected-links="repo_pulls /CMPUT302W14T04/Interface/pulls">
            <span class="octicon octicon-git-pull-request"></span> <span class="full-word">Pull Requests</span>
            <span class='counter'>0</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>


        <li class="tooltipped tooltipped-w" aria-label="Wiki">
          <a href="/CMPUT302W14T04/Interface/wiki" aria-label="Wiki" class="js-selected-navigation-item sunken-menu-item" data-pjax="true" data-selected-links="repo_wiki /CMPUT302W14T04/Interface/wiki">
            <span class="octicon octicon-book"></span> <span class="full-word">Wiki</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>        </li>
    </ul>
    <div class="sunken-menu-separator"></div>
    <ul class="sunken-menu-group">

      <li class="tooltipped tooltipped-w" aria-label="Pulse">
        <a href="/CMPUT302W14T04/Interface/pulse" aria-label="Pulse" class="js-selected-navigation-item sunken-menu-item" data-pjax="true" data-selected-links="pulse /CMPUT302W14T04/Interface/pulse">
          <span class="octicon octicon-pulse"></span> <span class="full-word">Pulse</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

      <li class="tooltipped tooltipped-w" aria-label="Graphs">
        <a href="/CMPUT302W14T04/Interface/graphs" aria-label="Graphs" class="js-selected-navigation-item sunken-menu-item" data-pjax="true" data-selected-links="repo_graphs repo_contributors /CMPUT302W14T04/Interface/graphs">
          <span class="octicon octicon-graph"></span> <span class="full-word">Graphs</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

      <li class="tooltipped tooltipped-w" aria-label="Network">
        <a href="/CMPUT302W14T04/Interface/network" aria-label="Network" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-selected-links="repo_network /CMPUT302W14T04/Interface/network">
          <span class="octicon octicon-git-branch"></span> <span class="full-word">Network</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>
    </ul>


      <div class="sunken-menu-separator"></div>
      <ul class="sunken-menu-group">
        <li class="tooltipped tooltipped-w" aria-label="Settings">
          <a href="/CMPUT302W14T04/Interface/settings"
            class="sunken-menu-item" data-pjax aria-label="Settings">
            <span class="octicon octicon-tools"></span> <span class="full-word">Settings</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
          </a>
        </li>
      </ul>
  </div>
</div>

              <div class="only-with-full-nav">
                

  

<div class="clone-url open"
  data-protocol-type="http"
  data-url="/users/set_protocol?protocol_selector=http&amp;protocol_type=push">
  <h3><strong>HTTPS</strong> clone URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="https://github.com/CMPUT302W14T04/Interface.git" readonly="readonly">

    <span aria-label="copy to clipboard" class="js-zeroclipboard url-box-clippy minibutton zeroclipboard-button" data-clipboard-text="https://github.com/CMPUT302W14T04/Interface.git" data-copied-hint="copied!"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>

  

<div class="clone-url "
  data-protocol-type="ssh"
  data-url="/users/set_protocol?protocol_selector=ssh&amp;protocol_type=push">
  <h3><strong>SSH</strong> clone URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="git@github.com:CMPUT302W14T04/Interface.git" readonly="readonly">

    <span aria-label="copy to clipboard" class="js-zeroclipboard url-box-clippy minibutton zeroclipboard-button" data-clipboard-text="git@github.com:CMPUT302W14T04/Interface.git" data-copied-hint="copied!"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>

  

<div class="clone-url "
  data-protocol-type="subversion"
  data-url="/users/set_protocol?protocol_selector=subversion&amp;protocol_type=push">
  <h3><strong>Subversion</strong> checkout URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="https://github.com/CMPUT302W14T04/Interface" readonly="readonly">

    <span aria-label="copy to clipboard" class="js-zeroclipboard url-box-clippy minibutton zeroclipboard-button" data-clipboard-text="https://github.com/CMPUT302W14T04/Interface" data-copied-hint="copied!"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>


<p class="clone-options">You can clone with
      <a href="#" class="js-clone-selector" data-protocol="http">HTTPS</a>,
      <a href="#" class="js-clone-selector" data-protocol="ssh">SSH</a>,
      or <a href="#" class="js-clone-selector" data-protocol="subversion">Subversion</a>.
  <span class="help tooltipped tooltipped-n" aria-label="Get help on which URL is right for you.">
    <a href="https://help.github.com/articles/which-remote-url-should-i-use">
    <span class="octicon octicon-question"></span>
    </a>
  </span>
</p>


  <a href="github-windows://openRepo/https://github.com/CMPUT302W14T04/Interface" class="minibutton sidebar-button" title="Save CMPUT302W14T04/Interface to your computer and use it in GitHub Desktop." aria-label="Save CMPUT302W14T04/Interface to your computer and use it in GitHub Desktop.">
    <span class="octicon octicon-device-desktop"></span>
    Clone in Desktop
  </a>

                <a href="/CMPUT302W14T04/Interface/archive/3f5b7764a8bb686f96f82fa28cab658614ef3168.zip"
                   class="minibutton sidebar-button"
                   aria-label="Download CMPUT302W14T04/Interface as a zip file"
                   title="Download CMPUT302W14T04/Interface as a zip file"
                   rel="nofollow">
                  <span class="octicon octicon-cloud-download"></span>
                  Download ZIP
                </a>
              </div>
        </div><!-- /.repository-sidebar -->

        <div id="js-repo-pjax-container" class="repository-content context-loader-container" data-pjax-container>
          


<!-- blob contrib key: blob_contributors:v21:ddabb1468dbbbef2365c81c87751b639 -->

<p title="This is a placeholder element" class="js-history-link-replace hidden"></p>

<a href="/CMPUT302W14T04/Interface/find/3f5b7764a8bb686f96f82fa28cab658614ef3168" data-pjax data-hotkey="t" class="js-show-file-finder" style="display:none">Show File Finder</a>

<div class="file-navigation">
  

<div class="select-menu js-menu-container js-select-menu" >
  <span class="minibutton select-menu-button js-menu-target" data-hotkey="w"
    data-master-branch="master"
    data-ref=""
    role="button" aria-label="Switch branches or tags" tabindex="0" aria-haspopup="true">
    <span class="octicon octicon-git-branch"></span>
    <i>tree:</i>
    <span class="js-select-button">3f5b7764a8</span>
  </span>

  <div class="select-menu-modal-holder js-menu-content js-navigation-container" data-pjax aria-hidden="true">

    <div class="select-menu-modal">
      <div class="select-menu-header">
        <span class="select-menu-title">Switch branches/tags</span>
        <span class="octicon octicon-remove-close js-menu-close"></span>
      </div> <!-- /.select-menu-header -->

      <div class="select-menu-filters">
        <div class="select-menu-text-filter">
          <input type="text" aria-label="Find or create a branch…" id="context-commitish-filter-field" class="js-filterable-field js-navigation-enable" placeholder="Find or create a branch…">
        </div>
        <div class="select-menu-tabs">
          <ul>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="branches" class="js-select-menu-tab">Branches</a>
            </li>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="tags" class="js-select-menu-tab">Tags</a>
            </li>
          </ul>
        </div><!-- /.select-menu-tabs -->
      </div><!-- /.select-menu-filters -->

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="branches">

        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


            <div class="select-menu-item js-navigation-item ">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <a href="/CMPUT302W14T04/Interface/blob/master/2wiiSoftware/src/wiiusej/test/WiiuseJGuiTest.java"
                 data-name="master"
                 data-skip-pjax="true"
                 rel="nofollow"
                 class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target"
                 title="master">master</a>
            </div> <!-- /.select-menu-item -->
        </div>

          <form accept-charset="UTF-8" action="/CMPUT302W14T04/Interface/branches" class="js-create-branch select-menu-item select-menu-new-item-form js-navigation-item js-new-item-form" method="post"><div style="margin:0;padding:0;display:inline"><input name="authenticity_token" type="hidden" value="nYF8rbCl0d2Qugt9YhkND+0MbgRopU2w8Fy5+0iHIDQ=" /></div>
            <span class="octicon octicon-git-branch-create select-menu-item-icon"></span>
            <div class="select-menu-item-text">
              <h4>Create branch: <span class="js-new-item-name"></span></h4>
              <span class="description">from ‘3f5b776’</span>
            </div>
            <input type="hidden" name="name" id="name" class="js-new-item-value">
            <input type="hidden" name="branch" id="branch" value="3f5b7764a8bb686f96f82fa28cab658614ef3168" />
            <input type="hidden" name="path" id="path" value="2wiiSoftware/src/wiiusej/test/WiiuseJGuiTest.java" />
          </form> <!-- /.select-menu-item -->

      </div> <!-- /.select-menu-list -->

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="tags">
        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


        </div>

        <div class="select-menu-no-results">Nothing to show</div>
      </div> <!-- /.select-menu-list -->

    </div> <!-- /.select-menu-modal -->
  </div> <!-- /.select-menu-modal-holder -->
</div> <!-- /.select-menu -->

  <div class="breadcrumb">
    <span class='repo-root js-repo-root'><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/CMPUT302W14T04/Interface/tree/3f5b7764a8bb686f96f82fa28cab658614ef3168" data-branch="3f5b7764a8bb686f96f82fa28cab658614ef3168" data-direction="back" data-pjax="true" itemscope="url" rel="nofollow"><span itemprop="title">Interface</span></a></span></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/CMPUT302W14T04/Interface/tree/3f5b7764a8bb686f96f82fa28cab658614ef3168/2wiiSoftware" data-branch="3f5b7764a8bb686f96f82fa28cab658614ef3168" data-direction="back" data-pjax="true" itemscope="url" rel="nofollow"><span itemprop="title">2wiiSoftware</span></a></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/CMPUT302W14T04/Interface/tree/3f5b7764a8bb686f96f82fa28cab658614ef3168/2wiiSoftware/src" data-branch="3f5b7764a8bb686f96f82fa28cab658614ef3168" data-direction="back" data-pjax="true" itemscope="url" rel="nofollow"><span itemprop="title">src</span></a></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/CMPUT302W14T04/Interface/tree/3f5b7764a8bb686f96f82fa28cab658614ef3168/2wiiSoftware/src/wiiusej" data-branch="3f5b7764a8bb686f96f82fa28cab658614ef3168" data-direction="back" data-pjax="true" itemscope="url" rel="nofollow"><span itemprop="title">wiiusej</span></a></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/CMPUT302W14T04/Interface/tree/3f5b7764a8bb686f96f82fa28cab658614ef3168/2wiiSoftware/src/wiiusej/test" data-branch="3f5b7764a8bb686f96f82fa28cab658614ef3168" data-direction="back" data-pjax="true" itemscope="url" rel="nofollow"><span itemprop="title">test</span></a></span><span class="separator"> / </span><strong class="final-path">WiiuseJGuiTest.java</strong> <span aria-label="copy to clipboard" class="js-zeroclipboard minibutton zeroclipboard-button" data-clipboard-text="2wiiSoftware/src/wiiusej/test/WiiuseJGuiTest.java" data-copied-hint="copied!"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>


  <div class="commit commit-loader file-history-tease js-deferred-content" data-url="/CMPUT302W14T04/Interface/contributors/3f5b7764a8bb686f96f82fa28cab658614ef3168/2wiiSoftware/src/wiiusej/test/WiiuseJGuiTest.java">
    Fetching contributors…

    <div class="participation">
      <p class="loader-loading"><img alt="Octocat-spinner-32-eaf2f5" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32-EAF2F5.gif" width="16" /></p>
      <p class="loader-error">Cannot retrieve contributors at this time</p>
    </div>
  </div>

<div class="file-box">
  <div class="file">
    <div class="meta clearfix">
      <div class="info file-name">
        <span class="icon"><b class="octicon octicon-file-text"></b></span>
        <span class="mode" title="File Mode">file</span>
        <span class="meta-divider"></span>
          <span>547 lines (458 sloc)</span>
          <span class="meta-divider"></span>
        <span>16.763 kb</span>
      </div>
      <div class="actions">
        <div class="button-group">
              <a class="minibutton disabled tooltipped tooltipped-w" href="#"
                 aria-label="You must be on a branch to make or propose changes to this file">Edit</a>
          <a href="/CMPUT302W14T04/Interface/raw/3f5b7764a8bb686f96f82fa28cab658614ef3168/2wiiSoftware/src/wiiusej/test/WiiuseJGuiTest.java" class="button minibutton " id="raw-url">Raw</a>
            <a href="/CMPUT302W14T04/Interface/blame/3f5b7764a8bb686f96f82fa28cab658614ef3168/2wiiSoftware/src/wiiusej/test/WiiuseJGuiTest.java" class="button minibutton js-update-url-with-hash">Blame</a>
          <a href="/CMPUT302W14T04/Interface/commits/3f5b7764a8bb686f96f82fa28cab658614ef3168/2wiiSoftware/src/wiiusej/test/WiiuseJGuiTest.java" class="button minibutton " rel="nofollow">History</a>
        </div><!-- /.button-group -->
          <a class="minibutton danger disabled empty-icon tooltipped tooltipped-w" href="#"
             aria-label="You must be on a branch to make or propose changes to this file">
          Delete
        </a>
      </div><!-- /.actions -->
    </div>
        <div class="blob-wrapper data type-java js-blob-data">
        <table class="file-code file-diff tab-size-8">
          <tr class="file-code-line">
            <td class="blob-line-nums">
              <span id="L1" rel="#L1">1</span>
<span id="L2" rel="#L2">2</span>
<span id="L3" rel="#L3">3</span>
<span id="L4" rel="#L4">4</span>
<span id="L5" rel="#L5">5</span>
<span id="L6" rel="#L6">6</span>
<span id="L7" rel="#L7">7</span>
<span id="L8" rel="#L8">8</span>
<span id="L9" rel="#L9">9</span>
<span id="L10" rel="#L10">10</span>
<span id="L11" rel="#L11">11</span>
<span id="L12" rel="#L12">12</span>
<span id="L13" rel="#L13">13</span>
<span id="L14" rel="#L14">14</span>
<span id="L15" rel="#L15">15</span>
<span id="L16" rel="#L16">16</span>
<span id="L17" rel="#L17">17</span>
<span id="L18" rel="#L18">18</span>
<span id="L19" rel="#L19">19</span>
<span id="L20" rel="#L20">20</span>
<span id="L21" rel="#L21">21</span>
<span id="L22" rel="#L22">22</span>
<span id="L23" rel="#L23">23</span>
<span id="L24" rel="#L24">24</span>
<span id="L25" rel="#L25">25</span>
<span id="L26" rel="#L26">26</span>
<span id="L27" rel="#L27">27</span>
<span id="L28" rel="#L28">28</span>
<span id="L29" rel="#L29">29</span>
<span id="L30" rel="#L30">30</span>
<span id="L31" rel="#L31">31</span>
<span id="L32" rel="#L32">32</span>
<span id="L33" rel="#L33">33</span>
<span id="L34" rel="#L34">34</span>
<span id="L35" rel="#L35">35</span>
<span id="L36" rel="#L36">36</span>
<span id="L37" rel="#L37">37</span>
<span id="L38" rel="#L38">38</span>
<span id="L39" rel="#L39">39</span>
<span id="L40" rel="#L40">40</span>
<span id="L41" rel="#L41">41</span>
<span id="L42" rel="#L42">42</span>
<span id="L43" rel="#L43">43</span>
<span id="L44" rel="#L44">44</span>
<span id="L45" rel="#L45">45</span>
<span id="L46" rel="#L46">46</span>
<span id="L47" rel="#L47">47</span>
<span id="L48" rel="#L48">48</span>
<span id="L49" rel="#L49">49</span>
<span id="L50" rel="#L50">50</span>
<span id="L51" rel="#L51">51</span>
<span id="L52" rel="#L52">52</span>
<span id="L53" rel="#L53">53</span>
<span id="L54" rel="#L54">54</span>
<span id="L55" rel="#L55">55</span>
<span id="L56" rel="#L56">56</span>
<span id="L57" rel="#L57">57</span>
<span id="L58" rel="#L58">58</span>
<span id="L59" rel="#L59">59</span>
<span id="L60" rel="#L60">60</span>
<span id="L61" rel="#L61">61</span>
<span id="L62" rel="#L62">62</span>
<span id="L63" rel="#L63">63</span>
<span id="L64" rel="#L64">64</span>
<span id="L65" rel="#L65">65</span>
<span id="L66" rel="#L66">66</span>
<span id="L67" rel="#L67">67</span>
<span id="L68" rel="#L68">68</span>
<span id="L69" rel="#L69">69</span>
<span id="L70" rel="#L70">70</span>
<span id="L71" rel="#L71">71</span>
<span id="L72" rel="#L72">72</span>
<span id="L73" rel="#L73">73</span>
<span id="L74" rel="#L74">74</span>
<span id="L75" rel="#L75">75</span>
<span id="L76" rel="#L76">76</span>
<span id="L77" rel="#L77">77</span>
<span id="L78" rel="#L78">78</span>
<span id="L79" rel="#L79">79</span>
<span id="L80" rel="#L80">80</span>
<span id="L81" rel="#L81">81</span>
<span id="L82" rel="#L82">82</span>
<span id="L83" rel="#L83">83</span>
<span id="L84" rel="#L84">84</span>
<span id="L85" rel="#L85">85</span>
<span id="L86" rel="#L86">86</span>
<span id="L87" rel="#L87">87</span>
<span id="L88" rel="#L88">88</span>
<span id="L89" rel="#L89">89</span>
<span id="L90" rel="#L90">90</span>
<span id="L91" rel="#L91">91</span>
<span id="L92" rel="#L92">92</span>
<span id="L93" rel="#L93">93</span>
<span id="L94" rel="#L94">94</span>
<span id="L95" rel="#L95">95</span>
<span id="L96" rel="#L96">96</span>
<span id="L97" rel="#L97">97</span>
<span id="L98" rel="#L98">98</span>
<span id="L99" rel="#L99">99</span>
<span id="L100" rel="#L100">100</span>
<span id="L101" rel="#L101">101</span>
<span id="L102" rel="#L102">102</span>
<span id="L103" rel="#L103">103</span>
<span id="L104" rel="#L104">104</span>
<span id="L105" rel="#L105">105</span>
<span id="L106" rel="#L106">106</span>
<span id="L107" rel="#L107">107</span>
<span id="L108" rel="#L108">108</span>
<span id="L109" rel="#L109">109</span>
<span id="L110" rel="#L110">110</span>
<span id="L111" rel="#L111">111</span>
<span id="L112" rel="#L112">112</span>
<span id="L113" rel="#L113">113</span>
<span id="L114" rel="#L114">114</span>
<span id="L115" rel="#L115">115</span>
<span id="L116" rel="#L116">116</span>
<span id="L117" rel="#L117">117</span>
<span id="L118" rel="#L118">118</span>
<span id="L119" rel="#L119">119</span>
<span id="L120" rel="#L120">120</span>
<span id="L121" rel="#L121">121</span>
<span id="L122" rel="#L122">122</span>
<span id="L123" rel="#L123">123</span>
<span id="L124" rel="#L124">124</span>
<span id="L125" rel="#L125">125</span>
<span id="L126" rel="#L126">126</span>
<span id="L127" rel="#L127">127</span>
<span id="L128" rel="#L128">128</span>
<span id="L129" rel="#L129">129</span>
<span id="L130" rel="#L130">130</span>
<span id="L131" rel="#L131">131</span>
<span id="L132" rel="#L132">132</span>
<span id="L133" rel="#L133">133</span>
<span id="L134" rel="#L134">134</span>
<span id="L135" rel="#L135">135</span>
<span id="L136" rel="#L136">136</span>
<span id="L137" rel="#L137">137</span>
<span id="L138" rel="#L138">138</span>
<span id="L139" rel="#L139">139</span>
<span id="L140" rel="#L140">140</span>
<span id="L141" rel="#L141">141</span>
<span id="L142" rel="#L142">142</span>
<span id="L143" rel="#L143">143</span>
<span id="L144" rel="#L144">144</span>
<span id="L145" rel="#L145">145</span>
<span id="L146" rel="#L146">146</span>
<span id="L147" rel="#L147">147</span>
<span id="L148" rel="#L148">148</span>
<span id="L149" rel="#L149">149</span>
<span id="L150" rel="#L150">150</span>
<span id="L151" rel="#L151">151</span>
<span id="L152" rel="#L152">152</span>
<span id="L153" rel="#L153">153</span>
<span id="L154" rel="#L154">154</span>
<span id="L155" rel="#L155">155</span>
<span id="L156" rel="#L156">156</span>
<span id="L157" rel="#L157">157</span>
<span id="L158" rel="#L158">158</span>
<span id="L159" rel="#L159">159</span>
<span id="L160" rel="#L160">160</span>
<span id="L161" rel="#L161">161</span>
<span id="L162" rel="#L162">162</span>
<span id="L163" rel="#L163">163</span>
<span id="L164" rel="#L164">164</span>
<span id="L165" rel="#L165">165</span>
<span id="L166" rel="#L166">166</span>
<span id="L167" rel="#L167">167</span>
<span id="L168" rel="#L168">168</span>
<span id="L169" rel="#L169">169</span>
<span id="L170" rel="#L170">170</span>
<span id="L171" rel="#L171">171</span>
<span id="L172" rel="#L172">172</span>
<span id="L173" rel="#L173">173</span>
<span id="L174" rel="#L174">174</span>
<span id="L175" rel="#L175">175</span>
<span id="L176" rel="#L176">176</span>
<span id="L177" rel="#L177">177</span>
<span id="L178" rel="#L178">178</span>
<span id="L179" rel="#L179">179</span>
<span id="L180" rel="#L180">180</span>
<span id="L181" rel="#L181">181</span>
<span id="L182" rel="#L182">182</span>
<span id="L183" rel="#L183">183</span>
<span id="L184" rel="#L184">184</span>
<span id="L185" rel="#L185">185</span>
<span id="L186" rel="#L186">186</span>
<span id="L187" rel="#L187">187</span>
<span id="L188" rel="#L188">188</span>
<span id="L189" rel="#L189">189</span>
<span id="L190" rel="#L190">190</span>
<span id="L191" rel="#L191">191</span>
<span id="L192" rel="#L192">192</span>
<span id="L193" rel="#L193">193</span>
<span id="L194" rel="#L194">194</span>
<span id="L195" rel="#L195">195</span>
<span id="L196" rel="#L196">196</span>
<span id="L197" rel="#L197">197</span>
<span id="L198" rel="#L198">198</span>
<span id="L199" rel="#L199">199</span>
<span id="L200" rel="#L200">200</span>
<span id="L201" rel="#L201">201</span>
<span id="L202" rel="#L202">202</span>
<span id="L203" rel="#L203">203</span>
<span id="L204" rel="#L204">204</span>
<span id="L205" rel="#L205">205</span>
<span id="L206" rel="#L206">206</span>
<span id="L207" rel="#L207">207</span>
<span id="L208" rel="#L208">208</span>
<span id="L209" rel="#L209">209</span>
<span id="L210" rel="#L210">210</span>
<span id="L211" rel="#L211">211</span>
<span id="L212" rel="#L212">212</span>
<span id="L213" rel="#L213">213</span>
<span id="L214" rel="#L214">214</span>
<span id="L215" rel="#L215">215</span>
<span id="L216" rel="#L216">216</span>
<span id="L217" rel="#L217">217</span>
<span id="L218" rel="#L218">218</span>
<span id="L219" rel="#L219">219</span>
<span id="L220" rel="#L220">220</span>
<span id="L221" rel="#L221">221</span>
<span id="L222" rel="#L222">222</span>
<span id="L223" rel="#L223">223</span>
<span id="L224" rel="#L224">224</span>
<span id="L225" rel="#L225">225</span>
<span id="L226" rel="#L226">226</span>
<span id="L227" rel="#L227">227</span>
<span id="L228" rel="#L228">228</span>
<span id="L229" rel="#L229">229</span>
<span id="L230" rel="#L230">230</span>
<span id="L231" rel="#L231">231</span>
<span id="L232" rel="#L232">232</span>
<span id="L233" rel="#L233">233</span>
<span id="L234" rel="#L234">234</span>
<span id="L235" rel="#L235">235</span>
<span id="L236" rel="#L236">236</span>
<span id="L237" rel="#L237">237</span>
<span id="L238" rel="#L238">238</span>
<span id="L239" rel="#L239">239</span>
<span id="L240" rel="#L240">240</span>
<span id="L241" rel="#L241">241</span>
<span id="L242" rel="#L242">242</span>
<span id="L243" rel="#L243">243</span>
<span id="L244" rel="#L244">244</span>
<span id="L245" rel="#L245">245</span>
<span id="L246" rel="#L246">246</span>
<span id="L247" rel="#L247">247</span>
<span id="L248" rel="#L248">248</span>
<span id="L249" rel="#L249">249</span>
<span id="L250" rel="#L250">250</span>
<span id="L251" rel="#L251">251</span>
<span id="L252" rel="#L252">252</span>
<span id="L253" rel="#L253">253</span>
<span id="L254" rel="#L254">254</span>
<span id="L255" rel="#L255">255</span>
<span id="L256" rel="#L256">256</span>
<span id="L257" rel="#L257">257</span>
<span id="L258" rel="#L258">258</span>
<span id="L259" rel="#L259">259</span>
<span id="L260" rel="#L260">260</span>
<span id="L261" rel="#L261">261</span>
<span id="L262" rel="#L262">262</span>
<span id="L263" rel="#L263">263</span>
<span id="L264" rel="#L264">264</span>
<span id="L265" rel="#L265">265</span>
<span id="L266" rel="#L266">266</span>
<span id="L267" rel="#L267">267</span>
<span id="L268" rel="#L268">268</span>
<span id="L269" rel="#L269">269</span>
<span id="L270" rel="#L270">270</span>
<span id="L271" rel="#L271">271</span>
<span id="L272" rel="#L272">272</span>
<span id="L273" rel="#L273">273</span>
<span id="L274" rel="#L274">274</span>
<span id="L275" rel="#L275">275</span>
<span id="L276" rel="#L276">276</span>
<span id="L277" rel="#L277">277</span>
<span id="L278" rel="#L278">278</span>
<span id="L279" rel="#L279">279</span>
<span id="L280" rel="#L280">280</span>
<span id="L281" rel="#L281">281</span>
<span id="L282" rel="#L282">282</span>
<span id="L283" rel="#L283">283</span>
<span id="L284" rel="#L284">284</span>
<span id="L285" rel="#L285">285</span>
<span id="L286" rel="#L286">286</span>
<span id="L287" rel="#L287">287</span>
<span id="L288" rel="#L288">288</span>
<span id="L289" rel="#L289">289</span>
<span id="L290" rel="#L290">290</span>
<span id="L291" rel="#L291">291</span>
<span id="L292" rel="#L292">292</span>
<span id="L293" rel="#L293">293</span>
<span id="L294" rel="#L294">294</span>
<span id="L295" rel="#L295">295</span>
<span id="L296" rel="#L296">296</span>
<span id="L297" rel="#L297">297</span>
<span id="L298" rel="#L298">298</span>
<span id="L299" rel="#L299">299</span>
<span id="L300" rel="#L300">300</span>
<span id="L301" rel="#L301">301</span>
<span id="L302" rel="#L302">302</span>
<span id="L303" rel="#L303">303</span>
<span id="L304" rel="#L304">304</span>
<span id="L305" rel="#L305">305</span>
<span id="L306" rel="#L306">306</span>
<span id="L307" rel="#L307">307</span>
<span id="L308" rel="#L308">308</span>
<span id="L309" rel="#L309">309</span>
<span id="L310" rel="#L310">310</span>
<span id="L311" rel="#L311">311</span>
<span id="L312" rel="#L312">312</span>
<span id="L313" rel="#L313">313</span>
<span id="L314" rel="#L314">314</span>
<span id="L315" rel="#L315">315</span>
<span id="L316" rel="#L316">316</span>
<span id="L317" rel="#L317">317</span>
<span id="L318" rel="#L318">318</span>
<span id="L319" rel="#L319">319</span>
<span id="L320" rel="#L320">320</span>
<span id="L321" rel="#L321">321</span>
<span id="L322" rel="#L322">322</span>
<span id="L323" rel="#L323">323</span>
<span id="L324" rel="#L324">324</span>
<span id="L325" rel="#L325">325</span>
<span id="L326" rel="#L326">326</span>
<span id="L327" rel="#L327">327</span>
<span id="L328" rel="#L328">328</span>
<span id="L329" rel="#L329">329</span>
<span id="L330" rel="#L330">330</span>
<span id="L331" rel="#L331">331</span>
<span id="L332" rel="#L332">332</span>
<span id="L333" rel="#L333">333</span>
<span id="L334" rel="#L334">334</span>
<span id="L335" rel="#L335">335</span>
<span id="L336" rel="#L336">336</span>
<span id="L337" rel="#L337">337</span>
<span id="L338" rel="#L338">338</span>
<span id="L339" rel="#L339">339</span>
<span id="L340" rel="#L340">340</span>
<span id="L341" rel="#L341">341</span>
<span id="L342" rel="#L342">342</span>
<span id="L343" rel="#L343">343</span>
<span id="L344" rel="#L344">344</span>
<span id="L345" rel="#L345">345</span>
<span id="L346" rel="#L346">346</span>
<span id="L347" rel="#L347">347</span>
<span id="L348" rel="#L348">348</span>
<span id="L349" rel="#L349">349</span>
<span id="L350" rel="#L350">350</span>
<span id="L351" rel="#L351">351</span>
<span id="L352" rel="#L352">352</span>
<span id="L353" rel="#L353">353</span>
<span id="L354" rel="#L354">354</span>
<span id="L355" rel="#L355">355</span>
<span id="L356" rel="#L356">356</span>
<span id="L357" rel="#L357">357</span>
<span id="L358" rel="#L358">358</span>
<span id="L359" rel="#L359">359</span>
<span id="L360" rel="#L360">360</span>
<span id="L361" rel="#L361">361</span>
<span id="L362" rel="#L362">362</span>
<span id="L363" rel="#L363">363</span>
<span id="L364" rel="#L364">364</span>
<span id="L365" rel="#L365">365</span>
<span id="L366" rel="#L366">366</span>
<span id="L367" rel="#L367">367</span>
<span id="L368" rel="#L368">368</span>
<span id="L369" rel="#L369">369</span>
<span id="L370" rel="#L370">370</span>
<span id="L371" rel="#L371">371</span>
<span id="L372" rel="#L372">372</span>
<span id="L373" rel="#L373">373</span>
<span id="L374" rel="#L374">374</span>
<span id="L375" rel="#L375">375</span>
<span id="L376" rel="#L376">376</span>
<span id="L377" rel="#L377">377</span>
<span id="L378" rel="#L378">378</span>
<span id="L379" rel="#L379">379</span>
<span id="L380" rel="#L380">380</span>
<span id="L381" rel="#L381">381</span>
<span id="L382" rel="#L382">382</span>
<span id="L383" rel="#L383">383</span>
<span id="L384" rel="#L384">384</span>
<span id="L385" rel="#L385">385</span>
<span id="L386" rel="#L386">386</span>
<span id="L387" rel="#L387">387</span>
<span id="L388" rel="#L388">388</span>
<span id="L389" rel="#L389">389</span>
<span id="L390" rel="#L390">390</span>
<span id="L391" rel="#L391">391</span>
<span id="L392" rel="#L392">392</span>
<span id="L393" rel="#L393">393</span>
<span id="L394" rel="#L394">394</span>
<span id="L395" rel="#L395">395</span>
<span id="L396" rel="#L396">396</span>
<span id="L397" rel="#L397">397</span>
<span id="L398" rel="#L398">398</span>
<span id="L399" rel="#L399">399</span>
<span id="L400" rel="#L400">400</span>
<span id="L401" rel="#L401">401</span>
<span id="L402" rel="#L402">402</span>
<span id="L403" rel="#L403">403</span>
<span id="L404" rel="#L404">404</span>
<span id="L405" rel="#L405">405</span>
<span id="L406" rel="#L406">406</span>
<span id="L407" rel="#L407">407</span>
<span id="L408" rel="#L408">408</span>
<span id="L409" rel="#L409">409</span>
<span id="L410" rel="#L410">410</span>
<span id="L411" rel="#L411">411</span>
<span id="L412" rel="#L412">412</span>
<span id="L413" rel="#L413">413</span>
<span id="L414" rel="#L414">414</span>
<span id="L415" rel="#L415">415</span>
<span id="L416" rel="#L416">416</span>
<span id="L417" rel="#L417">417</span>
<span id="L418" rel="#L418">418</span>
<span id="L419" rel="#L419">419</span>
<span id="L420" rel="#L420">420</span>
<span id="L421" rel="#L421">421</span>
<span id="L422" rel="#L422">422</span>
<span id="L423" rel="#L423">423</span>
<span id="L424" rel="#L424">424</span>
<span id="L425" rel="#L425">425</span>
<span id="L426" rel="#L426">426</span>
<span id="L427" rel="#L427">427</span>
<span id="L428" rel="#L428">428</span>
<span id="L429" rel="#L429">429</span>
<span id="L430" rel="#L430">430</span>
<span id="L431" rel="#L431">431</span>
<span id="L432" rel="#L432">432</span>
<span id="L433" rel="#L433">433</span>
<span id="L434" rel="#L434">434</span>
<span id="L435" rel="#L435">435</span>
<span id="L436" rel="#L436">436</span>
<span id="L437" rel="#L437">437</span>
<span id="L438" rel="#L438">438</span>
<span id="L439" rel="#L439">439</span>
<span id="L440" rel="#L440">440</span>
<span id="L441" rel="#L441">441</span>
<span id="L442" rel="#L442">442</span>
<span id="L443" rel="#L443">443</span>
<span id="L444" rel="#L444">444</span>
<span id="L445" rel="#L445">445</span>
<span id="L446" rel="#L446">446</span>
<span id="L447" rel="#L447">447</span>
<span id="L448" rel="#L448">448</span>
<span id="L449" rel="#L449">449</span>
<span id="L450" rel="#L450">450</span>
<span id="L451" rel="#L451">451</span>
<span id="L452" rel="#L452">452</span>
<span id="L453" rel="#L453">453</span>
<span id="L454" rel="#L454">454</span>
<span id="L455" rel="#L455">455</span>
<span id="L456" rel="#L456">456</span>
<span id="L457" rel="#L457">457</span>
<span id="L458" rel="#L458">458</span>
<span id="L459" rel="#L459">459</span>
<span id="L460" rel="#L460">460</span>
<span id="L461" rel="#L461">461</span>
<span id="L462" rel="#L462">462</span>
<span id="L463" rel="#L463">463</span>
<span id="L464" rel="#L464">464</span>
<span id="L465" rel="#L465">465</span>
<span id="L466" rel="#L466">466</span>
<span id="L467" rel="#L467">467</span>
<span id="L468" rel="#L468">468</span>
<span id="L469" rel="#L469">469</span>
<span id="L470" rel="#L470">470</span>
<span id="L471" rel="#L471">471</span>
<span id="L472" rel="#L472">472</span>
<span id="L473" rel="#L473">473</span>
<span id="L474" rel="#L474">474</span>
<span id="L475" rel="#L475">475</span>
<span id="L476" rel="#L476">476</span>
<span id="L477" rel="#L477">477</span>
<span id="L478" rel="#L478">478</span>
<span id="L479" rel="#L479">479</span>
<span id="L480" rel="#L480">480</span>
<span id="L481" rel="#L481">481</span>
<span id="L482" rel="#L482">482</span>
<span id="L483" rel="#L483">483</span>
<span id="L484" rel="#L484">484</span>
<span id="L485" rel="#L485">485</span>
<span id="L486" rel="#L486">486</span>
<span id="L487" rel="#L487">487</span>
<span id="L488" rel="#L488">488</span>
<span id="L489" rel="#L489">489</span>
<span id="L490" rel="#L490">490</span>
<span id="L491" rel="#L491">491</span>
<span id="L492" rel="#L492">492</span>
<span id="L493" rel="#L493">493</span>
<span id="L494" rel="#L494">494</span>
<span id="L495" rel="#L495">495</span>
<span id="L496" rel="#L496">496</span>
<span id="L497" rel="#L497">497</span>
<span id="L498" rel="#L498">498</span>
<span id="L499" rel="#L499">499</span>
<span id="L500" rel="#L500">500</span>
<span id="L501" rel="#L501">501</span>
<span id="L502" rel="#L502">502</span>
<span id="L503" rel="#L503">503</span>
<span id="L504" rel="#L504">504</span>
<span id="L505" rel="#L505">505</span>
<span id="L506" rel="#L506">506</span>
<span id="L507" rel="#L507">507</span>
<span id="L508" rel="#L508">508</span>
<span id="L509" rel="#L509">509</span>
<span id="L510" rel="#L510">510</span>
<span id="L511" rel="#L511">511</span>
<span id="L512" rel="#L512">512</span>
<span id="L513" rel="#L513">513</span>
<span id="L514" rel="#L514">514</span>
<span id="L515" rel="#L515">515</span>
<span id="L516" rel="#L516">516</span>
<span id="L517" rel="#L517">517</span>
<span id="L518" rel="#L518">518</span>
<span id="L519" rel="#L519">519</span>
<span id="L520" rel="#L520">520</span>
<span id="L521" rel="#L521">521</span>
<span id="L522" rel="#L522">522</span>
<span id="L523" rel="#L523">523</span>
<span id="L524" rel="#L524">524</span>
<span id="L525" rel="#L525">525</span>
<span id="L526" rel="#L526">526</span>
<span id="L527" rel="#L527">527</span>
<span id="L528" rel="#L528">528</span>
<span id="L529" rel="#L529">529</span>
<span id="L530" rel="#L530">530</span>
<span id="L531" rel="#L531">531</span>
<span id="L532" rel="#L532">532</span>
<span id="L533" rel="#L533">533</span>
<span id="L534" rel="#L534">534</span>
<span id="L535" rel="#L535">535</span>
<span id="L536" rel="#L536">536</span>
<span id="L537" rel="#L537">537</span>
<span id="L538" rel="#L538">538</span>
<span id="L539" rel="#L539">539</span>
<span id="L540" rel="#L540">540</span>
<span id="L541" rel="#L541">541</span>
<span id="L542" rel="#L542">542</span>
<span id="L543" rel="#L543">543</span>
<span id="L544" rel="#L544">544</span>
<span id="L545" rel="#L545">545</span>
<span id="L546" rel="#L546">546</span>

            </td>
            <td class="blob-line-code"><div class="code-body highlight"><pre><div class='line' id='LC1'><span class="cm">/**</span></div><div class='line' id='LC2'><span class="cm"> * This file is part of WiiuseJ.</span></div><div class='line' id='LC3'><span class="cm"> *</span></div><div class='line' id='LC4'><span class="cm"> *  WiiuseJ is free software: you can redistribute it and/or modify</span></div><div class='line' id='LC5'><span class="cm"> *  it under the terms of the GNU General Public License as published by</span></div><div class='line' id='LC6'><span class="cm"> *  the Free Software Foundation, either version 3 of the License, or</span></div><div class='line' id='LC7'><span class="cm"> *  (at your option) any later version.</span></div><div class='line' id='LC8'><span class="cm"> *</span></div><div class='line' id='LC9'><span class="cm"> *  WiiuseJ is distributed in the hope that it will be useful,</span></div><div class='line' id='LC10'><span class="cm"> *  but WITHOUT ANY WARRANTY; without even the implied warranty of</span></div><div class='line' id='LC11'><span class="cm"> *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the</span></div><div class='line' id='LC12'><span class="cm"> *  GNU General Public License for more details.</span></div><div class='line' id='LC13'><span class="cm"> *</span></div><div class='line' id='LC14'><span class="cm"> *  You should have received a copy of the GNU General Public License</span></div><div class='line' id='LC15'><span class="cm"> *  along with WiiuseJ.  If not, see &lt;http://www.gnu.org/licenses/&gt;.</span></div><div class='line' id='LC16'><span class="cm"> */</span></div><div class='line' id='LC17'><span class="kn">package</span> <span class="n">wiiusej</span><span class="o">.</span><span class="na">test</span><span class="o">;</span></div><div class='line' id='LC18'><br/></div><div class='line' id='LC19'><span class="kn">import</span> <span class="nn">java.awt.Color</span><span class="o">;</span></div><div class='line' id='LC20'><span class="kn">import</span> <span class="nn">java.awt.Dimension</span><span class="o">;</span></div><div class='line' id='LC21'><span class="kn">import</span> <span class="nn">java.awt.Font</span><span class="o">;</span></div><div class='line' id='LC22'><span class="kn">import</span> <span class="nn">java.awt.Toolkit</span><span class="o">;</span></div><div class='line' id='LC23'><span class="kn">import</span> <span class="nn">java.awt.event.MouseEvent</span><span class="o">;</span></div><div class='line' id='LC24'><br/></div><div class='line' id='LC25'><span class="kn">import</span> <span class="nn">javax.swing.BorderFactory</span><span class="o">;</span></div><div class='line' id='LC26'><span class="kn">import</span> <span class="nn">javax.swing.BoxLayout</span><span class="o">;</span></div><div class='line' id='LC27'><span class="kn">import</span> <span class="nn">javax.swing.GroupLayout</span><span class="o">;</span></div><div class='line' id='LC28'><span class="kn">import</span> <span class="nn">javax.swing.GroupLayout.Alignment</span><span class="o">;</span></div><div class='line' id='LC29'><span class="kn">import</span> <span class="nn">javax.swing.JButton</span><span class="o">;</span></div><div class='line' id='LC30'><span class="kn">import</span> <span class="nn">javax.swing.JFrame</span><span class="o">;</span></div><div class='line' id='LC31'><span class="kn">import</span> <span class="nn">javax.swing.JPanel</span><span class="o">;</span></div><div class='line' id='LC32'><span class="kn">import</span> <span class="nn">javax.swing.LayoutStyle.ComponentPlacement</span><span class="o">;</span></div><div class='line' id='LC33'><span class="kn">import</span> <span class="nn">javax.swing.WindowConstants</span><span class="o">;</span></div><div class='line' id='LC34'><span class="kn">import</span> <span class="nn">javax.swing.border.LineBorder</span><span class="o">;</span></div><div class='line' id='LC35'><span class="kn">import</span> <span class="nn">javax.swing.border.TitledBorder</span><span class="o">;</span></div><div class='line' id='LC36'><br/></div><div class='line' id='LC37'><span class="kn">import</span> <span class="nn">wiiusej.Wiimote</span><span class="o">;</span></div><div class='line' id='LC38'><span class="kn">import</span> <span class="nn">wiiusej.utils.IRCombined</span><span class="o">;</span></div><div class='line' id='LC39'><span class="kn">import</span> <span class="nn">wiiusej.utils.IRPanel</span><span class="o">;</span></div><div class='line' id='LC40'><span class="kn">import</span> <span class="nn">wiiusej.values.Calibrations</span><span class="o">;</span></div><div class='line' id='LC41'><span class="kn">import</span> <span class="nn">wiiusej.wiiusejevents.physicalevents.ExpansionEvent</span><span class="o">;</span></div><div class='line' id='LC42'><span class="kn">import</span> <span class="nn">wiiusej.wiiusejevents.physicalevents.IREvent</span><span class="o">;</span></div><div class='line' id='LC43'><span class="kn">import</span> <span class="nn">wiiusej.wiiusejevents.physicalevents.MotionSensingEvent</span><span class="o">;</span></div><div class='line' id='LC44'><span class="kn">import</span> <span class="nn">wiiusej.wiiusejevents.physicalevents.WiimoteButtonsEvent</span><span class="o">;</span></div><div class='line' id='LC45'><span class="kn">import</span> <span class="nn">wiiusej.wiiusejevents.utils.WiimoteListener</span><span class="o">;</span></div><div class='line' id='LC46'><span class="kn">import</span> <span class="nn">wiiusej.wiiusejevents.wiiuseapievents.DisconnectionEvent</span><span class="o">;</span></div><div class='line' id='LC47'><span class="kn">import</span> <span class="nn">wiiusej.wiiusejevents.wiiuseapievents.StatusEvent</span><span class="o">;</span></div><div class='line' id='LC48'><br/></div><div class='line' id='LC49'><br/></div><div class='line' id='LC50'><span class="kd">public</span> <span class="kd">class</span> <span class="nc">WiiuseJGuiTest</span> <span class="kd">extends</span> <span class="n">JFrame</span> <span class="kd">implements</span> <span class="n">WiimoteListener</span> <span class="o">{</span></div><div class='line' id='LC51'><br/></div><div class='line' id='LC52'>	<span class="c1">// declaration of variables</span></div><div class='line' id='LC53'>	<span class="kd">private</span> <span class="kd">static</span> <span class="kd">final</span> <span class="kt">long</span> <span class="n">serialVersionUID</span> <span class="o">=</span> <span class="mi">1L</span><span class="o">;</span></div><div class='line' id='LC54'><br/></div><div class='line' id='LC55'>	<span class="kd">private</span> <span class="kd">static</span> <span class="n">Wiimote</span> <span class="n">wiimote</span><span class="o">;</span></div><div class='line' id='LC56'>	<span class="kd">private</span> <span class="kd">static</span> <span class="n">Wiimote</span> <span class="n">wiimote2</span><span class="o">;</span></div><div class='line' id='LC57'>	<span class="kd">private</span> <span class="kd">static</span> <span class="n">Calibrations</span> <span class="n">cal</span> <span class="o">=</span> <span class="k">new</span> <span class="n">Calibrations</span><span class="o">();</span></div><div class='line' id='LC58'>	<span class="kd">private</span> <span class="kd">static</span> <span class="kt">boolean</span> <span class="n">isCalibrating</span> <span class="o">=</span> <span class="kc">false</span><span class="o">;</span></div><div class='line' id='LC59'>	<span class="kd">private</span> <span class="kd">static</span> <span class="kt">int</span><span class="o">[][]</span> <span class="n">calibMatrix</span> <span class="o">=</span> <span class="k">new</span> <span class="kt">int</span><span class="o">[</span><span class="mi">9</span><span class="o">][</span><span class="mi">2</span><span class="o">];</span></div><div class='line' id='LC60'><br/></div><div class='line' id='LC61'>	<span class="c1">// GUI-related variables</span></div><div class='line' id='LC62'>	<span class="kd">static</span> <span class="n">String</span> <span class="n">title</span> <span class="o">=</span> <span class="s">&quot;IR Paint&quot;</span><span class="o">;</span></div><div class='line' id='LC63'>	<span class="kd">static</span> <span class="kd">final</span> <span class="n">Color</span> <span class="n">black</span> <span class="o">=</span> <span class="n">Color</span><span class="o">.</span><span class="na">black</span><span class="o">;</span></div><div class='line' id='LC64'>	<span class="kd">static</span> <span class="kd">final</span> <span class="n">Color</span> <span class="n">red</span> <span class="o">=</span> <span class="n">Color</span><span class="o">.</span><span class="na">red</span><span class="o">;</span></div><div class='line' id='LC65'>	<span class="kd">static</span> <span class="kd">final</span> <span class="n">Color</span> <span class="n">bluegreen</span> <span class="o">=</span> <span class="k">new</span> <span class="n">Color</span><span class="o">(</span><span class="mi">0</span><span class="o">,</span> <span class="mi">153</span><span class="o">,</span> <span class="mi">153</span><span class="o">);</span></div><div class='line' id='LC66'><br/></div><div class='line' id='LC67'>	<span class="kd">static</span> <span class="kd">final</span> <span class="n">Font</span> <span class="n">Tahoma</span> <span class="o">=</span> <span class="k">new</span> <span class="n">Font</span><span class="o">(</span><span class="s">&quot;Tahoma&quot;</span><span class="o">,</span><span class="mi">0</span><span class="o">,</span><span class="mi">16</span><span class="o">);</span></div><div class='line' id='LC68'>	<span class="kd">static</span> <span class="kd">final</span> <span class="n">Dimension</span> <span class="n">screenSize</span> <span class="o">=</span> <span class="n">Toolkit</span><span class="o">.</span><span class="na">getDefaultToolkit</span><span class="o">().</span><span class="na">getScreenSize</span><span class="o">();</span></div><div class='line' id='LC69'><br/></div><div class='line' id='LC70'>	<span class="c1">// GUI: container panels</span></div><div class='line' id='LC71'>	<span class="kd">private</span> <span class="n">JPanel</span> <span class="n">buttonPanel</span><span class="o">;</span></div><div class='line' id='LC72'>	<span class="kd">private</span> <span class="n">JPanel</span> <span class="n">irCombinedPanel</span><span class="o">;</span></div><div class='line' id='LC73'>	<span class="kd">private</span> <span class="n">JPanel</span> <span class="n">irPadPanel</span><span class="o">;</span></div><div class='line' id='LC74'><br/></div><div class='line' id='LC75'>	<span class="c1">// GUI: draw panels</span></div><div class='line' id='LC76'>	<span class="kd">private</span> <span class="kd">static</span> <span class="n">JPanel</span> <span class="n">irViewPanel1</span><span class="o">;</span></div><div class='line' id='LC77'>	<span class="kd">private</span> <span class="kd">static</span> <span class="n">JPanel</span> <span class="n">irViewPanel2</span><span class="o">;</span></div><div class='line' id='LC78'>	<span class="kd">private</span> <span class="kd">static</span> <span class="n">JPanel</span> <span class="n">irCombined</span><span class="o">;</span></div><div class='line' id='LC79'><br/></div><div class='line' id='LC80'>	<span class="c1">// GUI: buttons</span></div><div class='line' id='LC81'>	<span class="kd">private</span> <span class="kd">static</span> <span class="n">JButton</span> <span class="n">calibButton</span><span class="o">;</span></div><div class='line' id='LC82'>	<span class="kd">private</span> <span class="n">JButton</span> <span class="n">LRButton</span><span class="o">;</span></div><div class='line' id='LC83'>	<span class="kd">private</span> <span class="n">JButton</span> <span class="n">clearDrawingButton</span><span class="o">;</span></div><div class='line' id='LC84'><br/></div><div class='line' id='LC85'>	<span class="cm">/**</span></div><div class='line' id='LC86'><span class="cm">	 * possible states for which point we are calibrating and where the wiimotes</span></div><div class='line' id='LC87'><span class="cm">	 * are</span></div><div class='line' id='LC88'><span class="cm">	 */</span></div><div class='line' id='LC89'>	<span class="kd">protected</span> <span class="kd">enum</span> <span class="n">cState</span> <span class="o">{</span></div><div class='line' id='LC90'><br/></div><div class='line' id='LC91'>		<span class="n">RIGHTBM</span><span class="o">(</span><span class="mi">7</span><span class="o">,</span> <span class="s">&quot;midpoint on the bottom edge&quot;</span><span class="o">,</span> <span class="kc">null</span><span class="o">),</span> </div><div class='line' id='LC92'>		<span class="n">RIGHTBR</span><span class="o">(</span><span class="mi">6</span><span class="o">,</span> <span class="s">&quot;bottom right&quot;</span><span class="o">,</span> <span class="n">RIGHTBM</span><span class="o">),</span> </div><div class='line' id='LC93'>		<span class="n">RIGHTMR</span><span class="o">(</span><span class="mi">5</span><span class="o">,</span> <span class="s">&quot;midpoint on the right edge&quot;</span><span class="o">,</span> <span class="n">RIGHTBR</span><span class="o">),</span> </div><div class='line' id='LC94'>		<span class="n">RIGHTTR</span><span class="o">(</span><span class="mi">4</span><span class="o">,</span> <span class="s">&quot;top right&quot;</span><span class="o">,</span> <span class="n">RIGHTMR</span><span class="o">),</span> </div><div class='line' id='LC95'>		<span class="n">RIGHTTM</span><span class="o">(</span><span class="mi">3</span><span class="o">,</span> <span class="s">&quot;midpoint on the top edge&quot;</span><span class="o">,</span> <span class="n">RIGHTTR</span><span class="o">),</span> </div><div class='line' id='LC96'>		<span class="n">RIGHTTL</span><span class="o">(</span><span class="mi">2</span><span class="o">,</span> <span class="s">&quot;top left&quot;</span><span class="o">,</span> <span class="n">RIGHTTM</span><span class="o">),</span> </div><div class='line' id='LC97'>		<span class="n">RIGHTML</span><span class="o">(</span><span class="mi">1</span><span class="o">,</span> <span class="s">&quot;midpoint of the left edge&quot;</span><span class="o">,</span> <span class="n">RIGHTTL</span><span class="o">),</span> </div><div class='line' id='LC98'>		<span class="n">RIGHTBL</span><span class="o">(</span><span class="mi">0</span><span class="o">,</span> <span class="s">&quot;bottom left&quot;</span><span class="o">,</span> <span class="n">RIGHTML</span><span class="o">),</span></div><div class='line' id='LC99'><br/></div><div class='line' id='LC100'>		<span class="n">LEFTMR</span><span class="o">(</span><span class="mi">7</span><span class="o">,</span> <span class="s">&quot;midpoint of the right edge&quot;</span><span class="o">,</span> <span class="kc">null</span><span class="o">),</span> </div><div class='line' id='LC101'>		<span class="n">LEFTTR</span><span class="o">(</span><span class="mi">6</span><span class="o">,</span> <span class="s">&quot;top right&quot;</span><span class="o">,</span> <span class="n">LEFTMR</span><span class="o">),</span> </div><div class='line' id='LC102'>		<span class="n">LEFTTM</span><span class="o">(</span><span class="mi">5</span><span class="o">,</span> <span class="s">&quot;midpoint of the top edge&quot;</span><span class="o">,</span> <span class="n">LEFTTR</span><span class="o">),</span> </div><div class='line' id='LC103'>		<span class="n">LEFTTL</span><span class="o">(</span><span class="mi">4</span><span class="o">,</span> <span class="s">&quot;top left&quot;</span><span class="o">,</span> <span class="n">LEFTTM</span><span class="o">),</span> </div><div class='line' id='LC104'>		<span class="n">LEFTML</span><span class="o">(</span><span class="mi">3</span><span class="o">,</span> <span class="s">&quot;midpoint of the left edge&quot;</span><span class="o">,</span><span class="n">LEFTTL</span><span class="o">),</span> </div><div class='line' id='LC105'>		<span class="n">LEFTBL</span><span class="o">(</span><span class="mi">2</span><span class="o">,</span> <span class="s">&quot;bottom left&quot;</span><span class="o">,</span> <span class="n">LEFTML</span><span class="o">),</span> </div><div class='line' id='LC106'>		<span class="n">LEFTBM</span><span class="o">(</span><span class="mi">1</span><span class="o">,</span> <span class="s">&quot;midpoint of the bottom edge&quot;</span><span class="o">,</span> <span class="n">LEFTBL</span><span class="o">),</span> </div><div class='line' id='LC107'>		<span class="n">LEFTBR</span><span class="o">(</span><span class="mi">0</span><span class="o">,</span> <span class="s">&quot;bottom right&quot;</span><span class="o">,</span> <span class="n">LEFTBM</span><span class="o">);</span></div><div class='line' id='LC108'><br/></div><div class='line' id='LC109'>		<span class="kt">int</span> <span class="n">order</span><span class="o">;</span></div><div class='line' id='LC110'>		<span class="n">String</span> <span class="n">position</span><span class="o">;</span></div><div class='line' id='LC111'>		<span class="n">cState</span> <span class="n">nextPosition</span><span class="o">;</span></div><div class='line' id='LC112'><br/></div><div class='line' id='LC113'>		<span class="cm">/*</span></div><div class='line' id='LC114'><span class="cm">		 * Format of states:</span></div><div class='line' id='LC115'><span class="cm">		 * Order, descriptive text, next point</span></div><div class='line' id='LC116'><span class="cm">		 * </span></div><div class='line' id='LC117'><span class="cm">		 * Order: numerical order for which step we are on in calibration</span></div><div class='line' id='LC118'><span class="cm">		 * Descriptive Text: text prepared for when we insert directions</span></div><div class='line' id='LC119'><span class="cm">		 * Next point: which is the next point to be calibrated</span></div><div class='line' id='LC120'><span class="cm">		 */</span></div><div class='line' id='LC121'><br/></div><div class='line' id='LC122'>		<span class="n">cState</span><span class="o">(</span><span class="kt">int</span> <span class="n">i</span><span class="o">,</span> <span class="n">String</span> <span class="n">p</span><span class="o">,</span> <span class="n">cState</span> <span class="n">next</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC123'>			<span class="n">order</span> <span class="o">=</span> <span class="n">i</span><span class="o">;</span> </div><div class='line' id='LC124'>			<span class="n">position</span> <span class="o">=</span> <span class="n">p</span><span class="o">;</span> </div><div class='line' id='LC125'>			<span class="n">nextPosition</span> <span class="o">=</span> <span class="n">next</span><span class="o">;</span> </div><div class='line' id='LC126'>		<span class="o">}</span></div><div class='line' id='LC127'><br/></div><div class='line' id='LC128'>		<span class="n">cState</span> <span class="nf">getNext</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC129'>			<span class="k">return</span> <span class="n">nextPosition</span><span class="o">;</span></div><div class='line' id='LC130'>		<span class="o">}</span></div><div class='line' id='LC131'><br/></div><div class='line' id='LC132'><br/></div><div class='line' id='LC133'>		<span class="cm">/**</span></div><div class='line' id='LC134'><span class="cm">		 * Calibrate function that is called when calibration button is pressed</span></div><div class='line' id='LC135'><span class="cm">		 * Function changes depending on state of which point is to be calibrated</span></div><div class='line' id='LC136'><span class="cm">		 * and where the wiimotes are (left vs right)</span></div><div class='line' id='LC137'><span class="cm">		 */</span></div><div class='line' id='LC138'>		<span class="kt">void</span> <span class="nf">calibrate</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC139'>			<span class="n">isCalibrating</span> <span class="o">=</span> <span class="kc">true</span><span class="o">;</span></div><div class='line' id='LC140'><br/></div><div class='line' id='LC141'>			<span class="k">if</span> <span class="o">(</span><span class="n">order</span> <span class="o">==</span> <span class="sc">&#39;0&#39;</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC142'>				<span class="c1">// enable this following block for real usage</span></div><div class='line' id='LC143'>				<span class="c1">// int[][] coords = cal.eventFilter(2);</span></div><div class='line' id='LC144'><br/></div><div class='line' id='LC145'>				<span class="c1">// for development purposes only; disable this block for real</span></div><div class='line' id='LC146'>				<span class="c1">// usage</span></div><div class='line' id='LC147'>				<span class="kt">int</span><span class="o">[][]</span> <span class="n">coords</span> <span class="o">=</span> <span class="n">cal</span><span class="o">.</span><span class="na">getFakeCalibPoints</span><span class="o">(</span><span class="n">calibButton</span><span class="o">,</span> <span class="mi">1</span><span class="o">);</span></div><div class='line' id='LC148'><br/></div><div class='line' id='LC149'>				<span class="n">cal</span><span class="o">.</span><span class="na">setF</span><span class="o">(</span><span class="mi">8</span><span class="n">f</span><span class="o">,</span> <span class="mf">5.5f</span><span class="o">);</span></div><div class='line' id='LC150'>				<span class="n">cal</span><span class="o">.</span><span class="na">setDefaultFloor</span><span class="o">((</span><span class="n">coords</span><span class="o">[</span><span class="mi">0</span><span class="o">][</span><span class="mi">1</span><span class="o">]</span> <span class="o">+</span> <span class="n">coords</span><span class="o">[</span><span class="mi">1</span><span class="o">][</span><span class="mi">1</span><span class="o">])</span> <span class="o">/</span> <span class="mi">2</span><span class="o">);</span></div><div class='line' id='LC151'>				<span class="n">cal</span><span class="o">.</span><span class="na">spatializeWiiMotes2x</span><span class="o">(</span><span class="n">coords</span><span class="o">[</span><span class="mi">0</span><span class="o">][</span><span class="mi">0</span><span class="o">],</span> <span class="n">coords</span><span class="o">[</span><span class="mi">1</span><span class="o">][</span><span class="mi">0</span><span class="o">],</span> <span class="n">wiimote</span><span class="o">,</span></div><div class='line' id='LC152'>						<span class="n">wiimote2</span><span class="o">);</span></div><div class='line' id='LC153'><br/></div><div class='line' id='LC154'>				<span class="c1">// what does this clearView do?</span></div><div class='line' id='LC155'>				<span class="n">clearViews</span><span class="o">();</span></div><div class='line' id='LC156'><br/></div><div class='line' id='LC157'>				<span class="n">calibMatrix</span><span class="o">[</span><span class="mi">0</span><span class="o">]</span> <span class="o">=</span> <span class="n">cal</span><span class="o">.</span><span class="na">calculateOffsets</span><span class="o">(</span><span class="n">coords</span><span class="o">[</span><span class="mi">0</span><span class="o">][</span><span class="mi">0</span><span class="o">],</span></div><div class='line' id='LC158'>						<span class="n">coords</span><span class="o">[</span><span class="mi">1</span><span class="o">][</span><span class="mi">0</span><span class="o">]);</span></div><div class='line' id='LC159'><br/></div><div class='line' id='LC160'>				<span class="n">calibButton</span><span class="o">.</span><span class="na">setEnabled</span><span class="o">(</span><span class="kc">true</span><span class="o">);</span></div><div class='line' id='LC161'>				<span class="n">calibButton</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="s">&quot;Capture Next Point&quot;</span><span class="o">);</span></div><div class='line' id='LC162'>				<span class="o">((</span><span class="n">IRCombined</span><span class="o">)</span> <span class="n">irCombined</span><span class="o">).</span><span class="na">drawCalib</span><span class="o">(</span><span class="n">calibMatrix</span><span class="o">[</span><span class="mi">0</span><span class="o">]);</span></div><div class='line' id='LC163'><br/></div><div class='line' id='LC164'>			<span class="o">}</span></div><div class='line' id='LC165'><br/></div><div class='line' id='LC166'>			<span class="k">else</span> <span class="o">{</span></div><div class='line' id='LC167'><br/></div><div class='line' id='LC168'>				<span class="c1">// insert calibration instruction here based on Order/Position</span></div><div class='line' id='LC169'><br/></div><div class='line' id='LC170'>				<span class="c1">// draw the source of the received IR</span></div><div class='line' id='LC171'><br/></div><div class='line' id='LC172'>				<span class="c1">// enable this following block for real usage</span></div><div class='line' id='LC173'>				<span class="c1">// int[][] temp = cal.getCalibPoints(calibButton);</span></div><div class='line' id='LC174'><br/></div><div class='line' id='LC175'>				<span class="c1">// for development purposes only; disable this block for real</span></div><div class='line' id='LC176'>				<span class="c1">// usage</span></div><div class='line' id='LC177'>				<span class="kt">int</span><span class="o">[][]</span> <span class="n">temp</span> <span class="o">=</span> <span class="n">cal</span><span class="o">.</span><span class="na">getFakeCalibPoints</span><span class="o">(</span><span class="n">calibButton</span><span class="o">,</span> <span class="n">order</span><span class="o">);</span></div><div class='line' id='LC178'><br/></div><div class='line' id='LC179'>				<span class="n">calibMatrix</span><span class="o">[</span><span class="n">order</span><span class="o">]</span> <span class="o">=</span> <span class="n">cal</span><span class="o">.</span><span class="na">calculateOffsets</span><span class="o">(</span><span class="n">temp</span><span class="o">[</span><span class="mi">0</span><span class="o">][</span><span class="mi">0</span><span class="o">],</span></div><div class='line' id='LC180'>						<span class="n">temp</span><span class="o">[</span><span class="mi">1</span><span class="o">][</span><span class="mi">0</span><span class="o">]);</span></div><div class='line' id='LC181'><br/></div><div class='line' id='LC182'>				<span class="o">((</span><span class="n">IRCombined</span><span class="o">)</span> <span class="n">irCombined</span><span class="o">).</span><span class="na">drawCalib</span><span class="o">(</span><span class="n">calibMatrix</span><span class="o">[</span><span class="n">order</span><span class="o">]);</span></div><div class='line' id='LC183'><br/></div><div class='line' id='LC184'>				<span class="c1">// when we finish calibration</span></div><div class='line' id='LC185'>				<span class="k">if</span> <span class="o">(</span><span class="n">order</span> <span class="o">==</span> <span class="mi">7</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC186'>					<span class="n">calibButton</span><span class="o">.</span><span class="na">setEnabled</span><span class="o">(</span><span class="kc">true</span><span class="o">);</span></div><div class='line' id='LC187'>					<span class="n">calibButton</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="s">&quot;Re-Calibrate&quot;</span><span class="o">);</span></div><div class='line' id='LC188'>					<span class="n">isCalibrating</span> <span class="o">=</span> <span class="kc">false</span><span class="o">;</span></div><div class='line' id='LC189'><br/></div><div class='line' id='LC190'>					<span class="n">cal</span><span class="o">.</span><span class="na">generateBoundaries</span><span class="o">(</span><span class="n">calibMatrix</span><span class="o">);</span></div><div class='line' id='LC191'>					<span class="c1">// remove drawn calibration points</span></div><div class='line' id='LC192'>					<span class="n">clearViews</span><span class="o">();</span></div><div class='line' id='LC193'>					<span class="n">printCaliState</span><span class="o">();</span></div><div class='line' id='LC194'>				<span class="o">}</span></div><div class='line' id='LC195'><br/></div><div class='line' id='LC196'>			<span class="o">}</span></div><div class='line' id='LC197'>		<span class="o">}</span></div><div class='line' id='LC198'><br/></div><div class='line' id='LC199'>	<span class="o">}</span></div><div class='line' id='LC200'><br/></div><div class='line' id='LC201'>	<span class="c1">// default state assumes that wiimotes are on the left</span></div><div class='line' id='LC202'>	<span class="kd">private</span> <span class="kd">static</span> <span class="n">cState</span> <span class="n">state</span> <span class="o">=</span> <span class="n">cState</span><span class="o">.</span><span class="na">LEFTBR</span><span class="o">;</span></div><div class='line' id='LC203'><br/></div><div class='line' id='LC204'>	<span class="cm">/**</span></div><div class='line' id='LC205'><span class="cm">	 * default constructor if no wiimotes are present</span></div><div class='line' id='LC206'><span class="cm">	 */</span></div><div class='line' id='LC207'>	<span class="kd">public</span> <span class="nf">WiiuseJGuiTest</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC208'>		<span class="n">initComponents</span><span class="o">();</span></div><div class='line' id='LC209'>		<span class="k">this</span><span class="o">.</span><span class="na">addWindowListener</span><span class="o">(</span><span class="k">new</span> <span class="n">CloseGuiTestCleanly</span><span class="o">());</span></div><div class='line' id='LC210'>	<span class="o">}</span></div><div class='line' id='LC211'><br/></div><div class='line' id='LC212'>	<span class="cm">/**</span></div><div class='line' id='LC213'><span class="cm">	 * Creates new form WiiuseJGuiTest</span></div><div class='line' id='LC214'><span class="cm">	 */</span></div><div class='line' id='LC215'>	<span class="kd">public</span> <span class="nf">WiiuseJGuiTest</span><span class="o">(</span><span class="n">Wiimote</span> <span class="n">wiimote</span><span class="o">,</span> <span class="n">Wiimote</span> <span class="n">wiimote2</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC216'>		<span class="n">initComponents</span><span class="o">();</span></div><div class='line' id='LC217'>		<span class="k">this</span><span class="o">.</span><span class="na">addWindowListener</span><span class="o">(</span><span class="k">new</span> <span class="n">CloseGuiTestCleanly</span><span class="o">());</span></div><div class='line' id='LC218'><br/></div><div class='line' id='LC219'>		<span class="c1">// checks for wiimote connection and setups the wiimote</span></div><div class='line' id='LC220'>		<span class="k">if</span> <span class="o">(</span><span class="n">wiimote</span> <span class="o">!=</span> <span class="kc">null</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC221'>			<span class="k">if</span> <span class="o">(</span><span class="n">wiimote2</span> <span class="o">!=</span> <span class="kc">null</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC222'><br/></div><div class='line' id='LC223'>				<span class="n">WiiuseJGuiTest</span><span class="o">.</span><span class="na">wiimote</span> <span class="o">=</span> <span class="n">wiimote</span><span class="o">;</span></div><div class='line' id='LC224'>				<span class="n">WiiuseJGuiTest</span><span class="o">.</span><span class="na">wiimote2</span> <span class="o">=</span> <span class="n">wiimote2</span><span class="o">;</span></div><div class='line' id='LC225'>				<span class="n">registerListeners</span><span class="o">();</span></div><div class='line' id='LC226'>				<span class="n">initWiimote</span><span class="o">();</span></div><div class='line' id='LC227'>				<span class="n">wiimote</span><span class="o">.</span><span class="na">activateIRTRacking</span><span class="o">();</span></div><div class='line' id='LC228'>				<span class="n">wiimote2</span><span class="o">.</span><span class="na">activateIRTRacking</span><span class="o">();</span></div><div class='line' id='LC229'>				<span class="n">calibButton</span><span class="o">.</span><span class="na">setEnabled</span><span class="o">(</span><span class="kc">false</span><span class="o">);</span></div><div class='line' id='LC230'>				<span class="n">calibButton</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="s">&quot;Locked&quot;</span><span class="o">);</span></div><div class='line' id='LC231'><br/></div><div class='line' id='LC232'>			<span class="o">}</span></div><div class='line' id='LC233'>		<span class="o">}</span></div><div class='line' id='LC234'>	<span class="o">}</span></div><div class='line' id='LC235'><br/></div><div class='line' id='LC236'>	<span class="kd">private</span> <span class="kd">static</span> <span class="kt">void</span> <span class="nf">clearViews</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC237'>		<span class="o">((</span><span class="n">IRPanel</span><span class="o">)</span> <span class="n">irViewPanel1</span><span class="o">).</span><span class="na">clearView</span><span class="o">();</span></div><div class='line' id='LC238'>		<span class="o">((</span><span class="n">IRPanel</span><span class="o">)</span> <span class="n">irViewPanel2</span><span class="o">).</span><span class="na">clearView</span><span class="o">();</span></div><div class='line' id='LC239'>		<span class="o">((</span><span class="n">IRCombined</span><span class="o">)</span> <span class="n">irCombined</span><span class="o">).</span><span class="na">clearView</span><span class="o">();</span></div><div class='line' id='LC240'>	<span class="o">}</span></div><div class='line' id='LC241'><br/></div><div class='line' id='LC242'>	<span class="kd">private</span> <span class="kt">void</span> <span class="nf">unregisterListeners</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC243'>		<span class="n">wiimote</span><span class="o">.</span><span class="na">removeWiiMoteEventListeners</span><span class="o">((</span><span class="n">IRPanel</span><span class="o">)</span> <span class="n">irViewPanel1</span><span class="o">);</span></div><div class='line' id='LC244'>		<span class="n">wiimote2</span><span class="o">.</span><span class="na">removeWiiMoteEventListeners</span><span class="o">((</span><span class="n">IRPanel</span><span class="o">)</span> <span class="n">irViewPanel2</span><span class="o">);</span></div><div class='line' id='LC245'>		<span class="n">wiimote</span><span class="o">.</span><span class="na">removeWiiMoteEventListeners</span><span class="o">(</span><span class="k">this</span><span class="o">);</span></div><div class='line' id='LC246'>	<span class="o">}</span></div><div class='line' id='LC247'><br/></div><div class='line' id='LC248'>	<span class="kd">private</span> <span class="kt">void</span> <span class="nf">initWiimote</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC249'>		<span class="n">wiimote</span><span class="o">.</span><span class="na">deactivateContinuous</span><span class="o">();</span></div><div class='line' id='LC250'>		<span class="n">wiimote</span><span class="o">.</span><span class="na">deactivateSmoothing</span><span class="o">();</span></div><div class='line' id='LC251'>		<span class="n">wiimote</span><span class="o">.</span><span class="na">setScreenAspectRatio169</span><span class="o">();</span></div><div class='line' id='LC252'>		<span class="n">wiimote</span><span class="o">.</span><span class="na">setSensorBarBelowScreen</span><span class="o">();</span></div><div class='line' id='LC253'>	<span class="o">}</span></div><div class='line' id='LC254'><br/></div><div class='line' id='LC255'>	<span class="kd">private</span> <span class="kt">void</span> <span class="nf">registerListeners</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC256'>		<span class="n">wiimote</span><span class="o">.</span><span class="na">addWiiMoteEventListeners</span><span class="o">((</span><span class="n">IRPanel</span><span class="o">)</span> <span class="n">irViewPanel1</span><span class="o">);</span></div><div class='line' id='LC257'>		<span class="n">wiimote2</span><span class="o">.</span><span class="na">addWiiMoteEventListeners</span><span class="o">((</span><span class="n">IRPanel</span><span class="o">)</span> <span class="n">irViewPanel2</span><span class="o">);</span></div><div class='line' id='LC258'>		<span class="n">wiimote</span><span class="o">.</span><span class="na">addWiiMoteEventListeners</span><span class="o">(</span><span class="k">this</span><span class="o">);</span></div><div class='line' id='LC259'><br/></div><div class='line' id='LC260'>	<span class="o">}</span></div><div class='line' id='LC261'><br/></div><div class='line' id='LC262'>	<span class="cm">/**</span></div><div class='line' id='LC263'><span class="cm">	 * Required function due to inheritance</span></div><div class='line' id='LC264'><span class="cm">	 */</span></div><div class='line' id='LC265'>	<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onButtonsEvent</span><span class="o">(</span><span class="n">WiimoteButtonsEvent</span> <span class="n">arg0</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC266'>		<span class="c1">// nothing</span></div><div class='line' id='LC267'>	<span class="o">}</span></div><div class='line' id='LC268'><br/></div><div class='line' id='LC269'>	<span class="cm">/**</span></div><div class='line' id='LC270'><span class="cm">	 * Required function due to inheritance Note: this is NOT the same onIrEvent</span></div><div class='line' id='LC271'><span class="cm">	 * used in IRCombine to draw later on</span></div><div class='line' id='LC272'><span class="cm">	 */</span></div><div class='line' id='LC273'>	<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onIrEvent</span><span class="o">(</span><span class="n">IREvent</span> <span class="n">arg0</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC274'>		<span class="c1">// nothing</span></div><div class='line' id='LC275'>	<span class="o">}</span></div><div class='line' id='LC276'><br/></div><div class='line' id='LC277'>	<span class="cm">/**</span></div><div class='line' id='LC278'><span class="cm">	 * Required function due to inheritance</span></div><div class='line' id='LC279'><span class="cm">	 */</span></div><div class='line' id='LC280'>	<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onMotionSensingEvent</span><span class="o">(</span><span class="n">MotionSensingEvent</span> <span class="n">arg0</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC281'>		<span class="c1">// nothing</span></div><div class='line' id='LC282'>	<span class="o">}</span></div><div class='line' id='LC283'><br/></div><div class='line' id='LC284'>	<span class="cm">/**</span></div><div class='line' id='LC285'><span class="cm">	 * Required function due to inheritance</span></div><div class='line' id='LC286'><span class="cm">	 */</span></div><div class='line' id='LC287'>	<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onExpansionEvent</span><span class="o">(</span><span class="n">ExpansionEvent</span> <span class="n">e</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC288'>		<span class="c1">// nothing yet</span></div><div class='line' id='LC289'>	<span class="o">}</span></div><div class='line' id='LC290'><br/></div><div class='line' id='LC291'>	<span class="cm">/**</span></div><div class='line' id='LC292'><span class="cm">	 * Required function due to inheritance</span></div><div class='line' id='LC293'><span class="cm">	 */</span></div><div class='line' id='LC294'>	<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onStatusEvent</span><span class="o">(</span><span class="n">StatusEvent</span> <span class="n">arg0</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC295'>		<span class="c1">// nothing yet</span></div><div class='line' id='LC296'>	<span class="o">}</span></div><div class='line' id='LC297'><br/></div><div class='line' id='LC298'>	<span class="cm">/**</span></div><div class='line' id='LC299'><span class="cm">	 * What happens when wiimote disconnects</span></div><div class='line' id='LC300'><span class="cm">	 */</span></div><div class='line' id='LC301'>	<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onDisconnectionEvent</span><span class="o">(</span><span class="n">DisconnectionEvent</span> <span class="n">arg0</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC302'>		<span class="n">unregisterListeners</span><span class="o">();</span></div><div class='line' id='LC303'>		<span class="n">clearViews</span><span class="o">();</span></div><div class='line' id='LC304'>	<span class="o">}</span></div><div class='line' id='LC305'><br/></div><div class='line' id='LC306'>	<span class="cm">/**</span></div><div class='line' id='LC307'><span class="cm">	 * Constructs the GUI</span></div><div class='line' id='LC308'><span class="cm">	 */</span></div><div class='line' id='LC309'>	<span class="kd">private</span> <span class="kt">void</span> <span class="nf">initComponents</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC310'><br/></div><div class='line' id='LC311'>		<span class="c1">// IR dot panel to show what an individual wiimote picks up</span></div><div class='line' id='LC312'>		<span class="n">irViewPanel1</span> <span class="o">=</span> <span class="k">new</span> <span class="n">IRPanel</span><span class="o">();</span></div><div class='line' id='LC313'>		<span class="n">irViewPanel2</span> <span class="o">=</span> <span class="k">new</span> <span class="n">IRPanel</span><span class="o">();</span></div><div class='line' id='LC314'>		<span class="c1">// draw the combined coordinates; the &quot;real picture&quot;</span></div><div class='line' id='LC315'>		<span class="n">irCombined</span> <span class="o">=</span> <span class="k">new</span> <span class="n">IRCombined</span><span class="o">();</span></div><div class='line' id='LC316'><br/></div><div class='line' id='LC317'>		<span class="c1">// this is the panel containing irCombined, formerly leftpanel</span></div><div class='line' id='LC318'>		<span class="n">irCombinedPanel</span> <span class="o">=</span> <span class="k">new</span> <span class="n">JPanel</span><span class="o">();</span></div><div class='line' id='LC319'>		<span class="c1">// this is the panel containing individual, formerly rightpanel</span></div><div class='line' id='LC320'>		<span class="n">irPadPanel</span> <span class="o">=</span> <span class="k">new</span> <span class="n">JPanel</span><span class="o">();</span></div><div class='line' id='LC321'>		<span class="c1">// this is the panel containing the 3 buttons</span></div><div class='line' id='LC322'>		<span class="n">buttonPanel</span> <span class="o">=</span> <span class="k">new</span> <span class="n">JPanel</span><span class="o">();</span></div><div class='line' id='LC323'><br/></div><div class='line' id='LC324'>		<span class="n">clearDrawingButton</span> <span class="o">=</span> <span class="k">new</span> <span class="n">JButton</span><span class="o">();</span></div><div class='line' id='LC325'>		<span class="n">calibButton</span> <span class="o">=</span> <span class="k">new</span> <span class="n">JButton</span><span class="o">();</span></div><div class='line' id='LC326'>		<span class="n">LRButton</span> <span class="o">=</span> <span class="k">new</span> <span class="n">JButton</span><span class="o">();</span></div><div class='line' id='LC327'><br/></div><div class='line' id='LC328'>		<span class="n">setDefaultCloseOperation</span><span class="o">(</span><span class="n">WindowConstants</span><span class="o">.</span><span class="na">EXIT_ON_CLOSE</span><span class="o">);</span></div><div class='line' id='LC329'>		<span class="n">setTitle</span><span class="o">(</span><span class="n">title</span><span class="o">);</span></div><div class='line' id='LC330'>		<span class="n">setName</span><span class="o">(</span><span class="n">title</span><span class="o">);</span> <span class="c1">// NOI18N</span></div><div class='line' id='LC331'><br/></div><div class='line' id='LC332'>		<span class="n">irPadPanel</span><span class="o">.</span><span class="na">setBorder</span><span class="o">(</span><span class="n">BorderFactory</span><span class="o">.</span><span class="na">createEtchedBorder</span><span class="o">());</span></div><div class='line' id='LC333'><br/></div><div class='line' id='LC334'>		<span class="n">irViewPanel1</span><span class="o">.</span><span class="na">setBackground</span><span class="o">(</span><span class="n">black</span><span class="o">);</span></div><div class='line' id='LC335'>		<span class="n">irViewPanel1</span><span class="o">.</span><span class="na">setBorder</span><span class="o">(</span><span class="n">BorderFactory</span><span class="o">.</span><span class="na">createTitledBorder</span><span class="o">(</span><span class="k">new</span> <span class="n">LineBorder</span><span class="o">(</span></div><div class='line' id='LC336'>				<span class="n">bluegreen</span><span class="o">,</span> <span class="mi">2</span><span class="o">,</span> <span class="kc">true</span><span class="o">),</span> <span class="s">&quot;IR: Remote #1&quot;</span><span class="o">,</span></div><div class='line' id='LC337'>				<span class="n">TitledBorder</span><span class="o">.</span><span class="na">DEFAULT_JUSTIFICATION</span><span class="o">,</span></div><div class='line' id='LC338'>				<span class="n">TitledBorder</span><span class="o">.</span><span class="na">DEFAULT_POSITION</span><span class="o">,</span> <span class="n">Tahoma</span><span class="o">,</span> <span class="n">red</span><span class="o">));</span></div><div class='line' id='LC339'>		<span class="n">irViewPanel1</span><span class="o">.</span><span class="na">setToolTipText</span><span class="o">(</span><span class="s">&quot;IREvent - Remote 1&quot;</span><span class="o">);</span></div><div class='line' id='LC340'>		<span class="n">GroupLayout</span> <span class="n">irViewPanelLayout1</span> <span class="o">=</span> <span class="k">new</span> <span class="n">GroupLayout</span><span class="o">(</span><span class="n">irViewPanel1</span><span class="o">);</span></div><div class='line' id='LC341'>		<span class="n">irViewPanel1</span><span class="o">.</span><span class="na">setLayout</span><span class="o">(</span><span class="n">irViewPanelLayout1</span><span class="o">);</span></div><div class='line' id='LC342'><br/></div><div class='line' id='LC343'>		<span class="n">irViewPanel2</span><span class="o">.</span><span class="na">setBackground</span><span class="o">(</span><span class="n">black</span><span class="o">);</span></div><div class='line' id='LC344'>		<span class="n">irViewPanel2</span><span class="o">.</span><span class="na">setBorder</span><span class="o">(</span><span class="n">BorderFactory</span><span class="o">.</span><span class="na">createTitledBorder</span><span class="o">(</span><span class="k">new</span> <span class="n">LineBorder</span><span class="o">(</span></div><div class='line' id='LC345'>				<span class="n">bluegreen</span><span class="o">,</span> <span class="mi">2</span><span class="o">,</span> <span class="kc">true</span><span class="o">),</span> <span class="s">&quot;IR: Remote #2&quot;</span><span class="o">,</span></div><div class='line' id='LC346'>				<span class="n">TitledBorder</span><span class="o">.</span><span class="na">DEFAULT_JUSTIFICATION</span><span class="o">,</span></div><div class='line' id='LC347'>				<span class="n">TitledBorder</span><span class="o">.</span><span class="na">DEFAULT_POSITION</span><span class="o">,</span> <span class="n">Tahoma</span><span class="o">,</span> <span class="n">red</span><span class="o">));</span></div><div class='line' id='LC348'>		<span class="n">irViewPanel2</span><span class="o">.</span><span class="na">setToolTipText</span><span class="o">(</span><span class="s">&quot;IREvent - Remote 2&quot;</span><span class="o">);</span></div><div class='line' id='LC349'>		<span class="n">GroupLayout</span> <span class="n">irViewPanelLayout2</span> <span class="o">=</span> <span class="k">new</span> <span class="n">GroupLayout</span><span class="o">(</span><span class="n">irViewPanel2</span><span class="o">);</span></div><div class='line' id='LC350'>		<span class="n">irViewPanel2</span><span class="o">.</span><span class="na">setLayout</span><span class="o">(</span><span class="n">irViewPanelLayout2</span><span class="o">);</span></div><div class='line' id='LC351'><br/></div><div class='line' id='LC352'>		<span class="n">irCombined</span><span class="o">.</span><span class="na">setBackground</span><span class="o">(</span><span class="n">black</span><span class="o">);</span></div><div class='line' id='LC353'>		<span class="n">irCombined</span><span class="o">.</span><span class="na">setBorder</span><span class="o">(</span><span class="n">BorderFactory</span><span class="o">.</span><span class="na">createTitledBorder</span><span class="o">(</span><span class="k">new</span> <span class="n">LineBorder</span><span class="o">(</span></div><div class='line' id='LC354'>				<span class="n">black</span><span class="o">,</span> <span class="mi">2</span><span class="o">,</span> <span class="kc">true</span><span class="o">),</span> <span class="s">&quot;IR: Combined&quot;</span><span class="o">,</span></div><div class='line' id='LC355'>				<span class="n">TitledBorder</span><span class="o">.</span><span class="na">DEFAULT_JUSTIFICATION</span><span class="o">,</span></div><div class='line' id='LC356'>				<span class="n">TitledBorder</span><span class="o">.</span><span class="na">DEFAULT_POSITION</span><span class="o">,</span> <span class="n">Tahoma</span><span class="o">,</span> <span class="n">black</span><span class="o">));</span></div><div class='line' id='LC357'>		<span class="n">irCombined</span><span class="o">.</span><span class="na">setToolTipText</span><span class="o">(</span><span class="s">&quot;IREvent - Combined View&quot;</span><span class="o">);</span></div><div class='line' id='LC358'>		<span class="n">GroupLayout</span> <span class="n">irCombinedLayout</span> <span class="o">=</span> <span class="k">new</span> <span class="n">GroupLayout</span><span class="o">(</span><span class="n">irCombined</span><span class="o">);</span></div><div class='line' id='LC359'>		<span class="n">irCombined</span><span class="o">.</span><span class="na">setLayout</span><span class="o">(</span><span class="n">irCombinedLayout</span><span class="o">);</span></div><div class='line' id='LC360'><br/></div><div class='line' id='LC361'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">irViewPanelLayout1</span><span class="o">.</span><span class="na">setHorizontalGroup</span><span class="o">(</span></div><div class='line' id='LC362'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">irViewPanelLayout1</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">LEADING</span><span class="o">)</span></div><div class='line' id='LC363'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGap</span><span class="o">(</span><span class="mi">0</span><span class="o">,</span> <span class="mi">272</span><span class="o">,</span> <span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">)</span></div><div class='line' id='LC364'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">);</span></div><div class='line' id='LC365'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">irViewPanelLayout1</span><span class="o">.</span><span class="na">setVerticalGroup</span><span class="o">(</span></div><div class='line' id='LC366'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">irViewPanelLayout1</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">LEADING</span><span class="o">)</span></div><div class='line' id='LC367'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGap</span><span class="o">(</span><span class="mi">0</span><span class="o">,</span> <span class="mi">299</span><span class="o">,</span> <span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">)</span></div><div class='line' id='LC368'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">);</span></div><div class='line' id='LC369'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC370'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">irViewPanelLayout2</span><span class="o">.</span><span class="na">setHorizontalGroup</span><span class="o">(</span></div><div class='line' id='LC371'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">irViewPanelLayout2</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">LEADING</span><span class="o">)</span></div><div class='line' id='LC372'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGap</span><span class="o">(</span><span class="mi">0</span><span class="o">,</span> <span class="mi">272</span><span class="o">,</span> <span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">)</span></div><div class='line' id='LC373'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">);</span></div><div class='line' id='LC374'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">irViewPanelLayout2</span><span class="o">.</span><span class="na">setVerticalGroup</span><span class="o">(</span></div><div class='line' id='LC375'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">irViewPanelLayout2</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">LEADING</span><span class="o">)</span></div><div class='line' id='LC376'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGap</span><span class="o">(</span><span class="mi">0</span><span class="o">,</span> <span class="mi">299</span><span class="o">,</span> <span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">)</span></div><div class='line' id='LC377'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">);</span></div><div class='line' id='LC378'><br/></div><div class='line' id='LC379'>		<span class="n">irCombinedLayout</span><span class="o">.</span><span class="na">setHorizontalGroup</span><span class="o">(</span><span class="n">irCombinedLayout</span></div><div class='line' id='LC380'>				<span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">LEADING</span><span class="o">).</span><span class="na">addGap</span><span class="o">(</span><span class="mi">0</span><span class="o">,</span></div><div class='line' id='LC381'>						<span class="mi">272</span><span class="o">,</span> <span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">));</span></div><div class='line' id='LC382'>		<span class="n">irCombinedLayout</span><span class="o">.</span><span class="na">setVerticalGroup</span><span class="o">(</span><span class="n">irCombinedLayout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span></div><div class='line' id='LC383'>				<span class="n">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">LEADING</span><span class="o">).</span><span class="na">addGap</span><span class="o">(</span><span class="mi">0</span><span class="o">,</span> <span class="mi">299</span><span class="o">,</span> <span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">));</span></div><div class='line' id='LC384'><br/></div><div class='line' id='LC385'>		<span class="n">irCombinedPanel</span><span class="o">.</span><span class="na">setBorder</span><span class="o">(</span><span class="n">BorderFactory</span><span class="o">.</span><span class="na">createEtchedBorder</span><span class="o">());</span></div><div class='line' id='LC386'>		<span class="n">irCombinedPanel</span><span class="o">.</span><span class="na">setLayout</span><span class="o">(</span><span class="k">new</span> <span class="n">BoxLayout</span><span class="o">(</span><span class="n">irCombinedPanel</span><span class="o">,</span></div><div class='line' id='LC387'>				<span class="n">BoxLayout</span><span class="o">.</span><span class="na">LINE_AXIS</span><span class="o">));</span></div><div class='line' id='LC388'><br/></div><div class='line' id='LC389'>		<span class="n">clearDrawingButton</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="s">&quot;Clear&quot;</span><span class="o">);</span></div><div class='line' id='LC390'>		<span class="n">clearDrawingButton</span><span class="o">.</span><span class="na">addMouseListener</span><span class="o">(</span><span class="k">new</span> <span class="n">java</span><span class="o">.</span><span class="na">awt</span><span class="o">.</span><span class="na">event</span><span class="o">.</span><span class="na">MouseAdapter</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC391'>			<span class="kd">public</span> <span class="kt">void</span> <span class="nf">mousePressed</span><span class="o">(</span><span class="n">java</span><span class="o">.</span><span class="na">awt</span><span class="o">.</span><span class="na">event</span><span class="o">.</span><span class="na">MouseEvent</span> <span class="n">evt</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC392'>				<span class="n">clearDrawingButtonMousePressed</span><span class="o">(</span><span class="n">evt</span><span class="o">);</span></div><div class='line' id='LC393'>			<span class="o">}</span></div><div class='line' id='LC394'>		<span class="o">});</span></div><div class='line' id='LC395'>		<span class="n">buttonPanel</span><span class="o">.</span><span class="na">add</span><span class="o">(</span><span class="n">clearDrawingButton</span><span class="o">);</span></div><div class='line' id='LC396'><br/></div><div class='line' id='LC397'>		<span class="n">calibButton</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="s">&quot;Start Calibration&quot;</span><span class="o">);</span></div><div class='line' id='LC398'>		<span class="n">calibButton</span><span class="o">.</span><span class="na">addMouseListener</span><span class="o">(</span><span class="k">new</span> <span class="n">java</span><span class="o">.</span><span class="na">awt</span><span class="o">.</span><span class="na">event</span><span class="o">.</span><span class="na">MouseAdapter</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC399'>			<span class="kd">public</span> <span class="kt">void</span> <span class="nf">mousePressed</span><span class="o">(</span><span class="n">java</span><span class="o">.</span><span class="na">awt</span><span class="o">.</span><span class="na">event</span><span class="o">.</span><span class="na">MouseEvent</span> <span class="n">evt</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC400'>				<span class="n">calibButtonMousePressed</span><span class="o">(</span><span class="n">evt</span><span class="o">);</span></div><div class='line' id='LC401'>			<span class="o">}</span></div><div class='line' id='LC402'>		<span class="o">});</span></div><div class='line' id='LC403'>		<span class="n">buttonPanel</span><span class="o">.</span><span class="na">add</span><span class="o">(</span><span class="n">calibButton</span><span class="o">);</span></div><div class='line' id='LC404'><br/></div><div class='line' id='LC405'>		<span class="n">LRButton</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="s">&quot;Left&quot;</span><span class="o">);</span></div><div class='line' id='LC406'>		<span class="n">LRButton</span><span class="o">.</span><span class="na">addMouseListener</span><span class="o">(</span><span class="k">new</span> <span class="n">java</span><span class="o">.</span><span class="na">awt</span><span class="o">.</span><span class="na">event</span><span class="o">.</span><span class="na">MouseAdapter</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC407'>			<span class="kd">public</span> <span class="kt">void</span> <span class="nf">mousePressed</span><span class="o">(</span><span class="n">java</span><span class="o">.</span><span class="na">awt</span><span class="o">.</span><span class="na">event</span><span class="o">.</span><span class="na">MouseEvent</span> <span class="n">evt</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC408'>				<span class="n">LRButtonMousePressed</span><span class="o">(</span><span class="n">evt</span><span class="o">);</span></div><div class='line' id='LC409'>			<span class="o">}</span></div><div class='line' id='LC410'>		<span class="o">});</span></div><div class='line' id='LC411'>		<span class="n">buttonPanel</span><span class="o">.</span><span class="na">add</span><span class="o">(</span><span class="n">LRButton</span><span class="o">);</span></div><div class='line' id='LC412'><br/></div><div class='line' id='LC413'>		<span class="n">GroupLayout</span> <span class="n">irPadPanelLayout</span> <span class="o">=</span> <span class="k">new</span> <span class="n">GroupLayout</span><span class="o">(</span><span class="n">irPadPanel</span><span class="o">);</span></div><div class='line' id='LC414'>		<span class="n">irPadPanel</span><span class="o">.</span><span class="na">setLayout</span><span class="o">(</span><span class="n">irPadPanelLayout</span><span class="o">);</span></div><div class='line' id='LC415'>		<span class="n">irPadPanelLayout</span><span class="o">.</span><span class="na">setHorizontalGroup</span><span class="o">(</span></div><div class='line' id='LC416'>				<span class="n">irPadPanelLayout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">LEADING</span><span class="o">)</span></div><div class='line' id='LC417'>				<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">irViewPanel1</span><span class="o">,</span> <span class="n">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">TRAILING</span><span class="o">,</span></div><div class='line' id='LC418'>						<span class="n">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="n">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span></div><div class='line' id='LC419'>						<span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">)</span></div><div class='line' id='LC420'>				<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">irViewPanel2</span><span class="o">,</span> <span class="n">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">TRAILING</span><span class="o">,</span></div><div class='line' id='LC421'>						<span class="n">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="n">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span></div><div class='line' id='LC422'>						<span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">)</span></div><div class='line' id='LC423'>				<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">buttonPanel</span><span class="o">,</span> <span class="n">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">TRAILING</span><span class="o">,</span></div><div class='line' id='LC424'>						<span class="n">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="n">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span></div><div class='line' id='LC425'>						<span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">));</span></div><div class='line' id='LC426'>		<span class="n">irPadPanelLayout</span><span class="o">.</span><span class="na">setVerticalGroup</span><span class="o">(</span><span class="n">irPadPanelLayout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span></div><div class='line' id='LC427'>				<span class="n">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">LEADING</span><span class="o">).</span><span class="na">addGroup</span><span class="o">(</span></div><div class='line' id='LC428'>				<span class="n">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">TRAILING</span><span class="o">,</span></div><div class='line' id='LC429'>				<span class="n">irPadPanelLayout</span></div><div class='line' id='LC430'>						<span class="o">.</span><span class="na">createSequentialGroup</span><span class="o">()</span></div><div class='line' id='LC431'>						<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">buttonPanel</span><span class="o">,</span> <span class="n">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span></div><div class='line' id='LC432'>								<span class="n">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">)</span></div><div class='line' id='LC433'>						<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">irViewPanel1</span><span class="o">,</span> <span class="n">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span></div><div class='line' id='LC434'>								<span class="n">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">)</span></div><div class='line' id='LC435'>						<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">irViewPanel2</span><span class="o">,</span> <span class="n">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span></div><div class='line' id='LC436'>								<span class="n">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">)</span></div><div class='line' id='LC437'><br/></div><div class='line' id='LC438'>		<span class="o">));</span></div><div class='line' id='LC439'><br/></div><div class='line' id='LC440'>		<span class="n">irCombinedPanel</span><span class="o">.</span><span class="na">add</span><span class="o">(</span><span class="n">irCombined</span><span class="o">);</span></div><div class='line' id='LC441'>		<span class="n">GroupLayout</span> <span class="n">layout</span> <span class="o">=</span> <span class="k">new</span> <span class="n">GroupLayout</span><span class="o">(</span><span class="n">getContentPane</span><span class="o">());</span></div><div class='line' id='LC442'>		<span class="n">getContentPane</span><span class="o">().</span><span class="na">setLayout</span><span class="o">(</span><span class="n">layout</span><span class="o">);</span></div><div class='line' id='LC443'>		<span class="n">layout</span><span class="o">.</span><span class="na">setHorizontalGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span></div><div class='line' id='LC444'>				<span class="n">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">LEADING</span><span class="o">).</span><span class="na">addGroup</span><span class="o">(</span></div><div class='line' id='LC445'>				<span class="n">layout</span><span class="o">.</span><span class="na">createSequentialGroup</span><span class="o">()</span></div><div class='line' id='LC446'>						<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">irPadPanel</span><span class="o">,</span> <span class="n">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">,</span></div><div class='line' id='LC447'>								<span class="mi">238</span><span class="o">,</span> <span class="n">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">)</span></div><div class='line' id='LC448'>						<span class="o">.</span><span class="na">addPreferredGap</span><span class="o">(</span><span class="n">ComponentPlacement</span><span class="o">.</span><span class="na">RELATED</span><span class="o">)</span></div><div class='line' id='LC449'>						<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">irCombinedPanel</span><span class="o">,</span></div><div class='line' id='LC450'>								<span class="n">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="mi">498</span><span class="o">,</span> <span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">))</span></div><div class='line' id='LC451'><br/></div><div class='line' id='LC452'>		<span class="o">);</span></div><div class='line' id='LC453'>		<span class="n">layout</span><span class="o">.</span><span class="na">setVerticalGroup</span><span class="o">(</span><span class="n">layout</span></div><div class='line' id='LC454'>				<span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">Alignment</span><span class="o">.</span><span class="na">LEADING</span><span class="o">)</span></div><div class='line' id='LC455'>				<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">irPadPanel</span><span class="o">,</span> <span class="n">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="mi">573</span><span class="o">,</span></div><div class='line' id='LC456'>						<span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">)</span></div><div class='line' id='LC457'>				<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">irCombinedPanel</span><span class="o">,</span> <span class="n">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="mi">573</span><span class="o">,</span></div><div class='line' id='LC458'>						<span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">));</span></div><div class='line' id='LC459'><br/></div><div class='line' id='LC460'>		<span class="n">setBounds</span><span class="o">((</span><span class="n">screenSize</span><span class="o">.</span><span class="na">width</span> <span class="o">-</span> <span class="mi">800</span><span class="o">)</span> <span class="o">/</span> <span class="mi">2</span><span class="o">,</span> <span class="o">(</span><span class="n">screenSize</span><span class="o">.</span><span class="na">height</span> <span class="o">-</span> <span class="mi">600</span><span class="o">)</span> <span class="o">/</span> <span class="mi">2</span><span class="o">,</span></div><div class='line' id='LC461'>				<span class="mi">800</span><span class="o">,</span> <span class="mi">600</span><span class="o">);</span></div><div class='line' id='LC462'><br/></div><div class='line' id='LC463'>	<span class="o">}</span><span class="c1">// &lt;/editor-fold&gt;//GEN-END:initComponents</span></div><div class='line' id='LC464'><br/></div><div class='line' id='LC465'>	<span class="kd">private</span> <span class="kt">void</span> <span class="nf">clearDrawingButtonMousePressed</span><span class="o">(</span><span class="n">MouseEvent</span> <span class="n">evt</span><span class="o">)</span> <span class="o">{</span><span class="c1">// GEN-FIRST:event_clearDrawingButtonMousePressed</span></div><div class='line' id='LC466'>		<span class="k">if</span> <span class="o">(</span><span class="n">clearDrawingButton</span><span class="o">.</span><span class="na">isEnabled</span><span class="o">())</span> <span class="o">{</span></div><div class='line' id='LC467'>			<span class="n">clearViews</span><span class="o">();</span></div><div class='line' id='LC468'>		<span class="o">}</span></div><div class='line' id='LC469'>	<span class="o">}</span><span class="c1">// GEN-LAST:event_clearDrawingButtonMousePressed</span></div><div class='line' id='LC470'><br/></div><div class='line' id='LC471'>	<span class="kd">private</span> <span class="kt">void</span> <span class="nf">calibButtonMousePressed</span><span class="o">(</span><span class="n">MouseEvent</span> <span class="n">evt</span><span class="o">)</span> <span class="o">{</span><span class="c1">// GEN-FIRST:event_calibButtonMousePressed</span></div><div class='line' id='LC472'>		<span class="k">if</span> <span class="o">(</span><span class="n">calibButton</span><span class="o">.</span><span class="na">isEnabled</span><span class="o">())</span> <span class="o">{</span></div><div class='line' id='LC473'>			<span class="c1">// debug statement block</span></div><div class='line' id='LC474'>			<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">&quot;Button got pressed!&quot;</span><span class="o">);</span></div><div class='line' id='LC475'>			<span class="n">printCaliState</span><span class="o">();</span></div><div class='line' id='LC476'>			<span class="n">calibButton</span><span class="o">.</span><span class="na">setEnabled</span><span class="o">(</span><span class="kc">false</span><span class="o">);</span></div><div class='line' id='LC477'>			<span class="n">calibButton</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="s">&quot;Locked&quot;</span><span class="o">);</span></div><div class='line' id='LC478'>			<span class="n">state</span><span class="o">.</span><span class="na">calibrate</span><span class="o">();</span></div><div class='line' id='LC479'>			<span class="n">setState</span><span class="o">(</span><span class="n">state</span><span class="o">.</span><span class="na">getNext</span><span class="o">());</span></div><div class='line' id='LC480'>		<span class="o">}</span></div><div class='line' id='LC481'>	<span class="o">}</span><span class="c1">// GEN-LAST:event_calibButtonMousePressed</span></div><div class='line' id='LC482'><br/></div><div class='line' id='LC483'>	<span class="kd">private</span> <span class="kt">void</span> <span class="nf">LRButtonMousePressed</span><span class="o">(</span><span class="n">MouseEvent</span> <span class="n">evt</span><span class="o">)</span> <span class="o">{</span><span class="c1">// GEN-FIRST:event_LRButtonMousePressed</span></div><div class='line' id='LC484'>		<span class="c1">// only allow changing of left and right if we are not in the middle of</span></div><div class='line' id='LC485'>		<span class="c1">// a calibration</span></div><div class='line' id='LC486'>		<span class="c1">// changes initial starting state as well</span></div><div class='line' id='LC487'>		<span class="k">if</span> <span class="o">(!</span><span class="n">isCalibrating</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC488'>			<span class="k">if</span> <span class="o">(</span><span class="n">LRButton</span><span class="o">.</span><span class="na">isEnabled</span><span class="o">())</span> <span class="o">{</span></div><div class='line' id='LC489'>				<span class="n">LRButton</span><span class="o">.</span><span class="na">setEnabled</span><span class="o">(</span><span class="kc">false</span><span class="o">);</span></div><div class='line' id='LC490'>				<span class="n">LRButton</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="s">&quot;Right&quot;</span><span class="o">);</span></div><div class='line' id='LC491'>				<span class="n">cal</span><span class="o">.</span><span class="na">leftSide</span> <span class="o">=</span> <span class="kc">false</span><span class="o">;</span></div><div class='line' id='LC492'>				<span class="n">setState</span><span class="o">(</span><span class="n">cState</span><span class="o">.</span><span class="na">RIGHTBL</span><span class="o">);</span></div><div class='line' id='LC493'>			<span class="o">}</span> <span class="k">else</span> <span class="o">{</span></div><div class='line' id='LC494'>				<span class="n">LRButton</span><span class="o">.</span><span class="na">setEnabled</span><span class="o">(</span><span class="kc">true</span><span class="o">);</span></div><div class='line' id='LC495'>				<span class="n">LRButton</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="s">&quot;Left&quot;</span><span class="o">);</span></div><div class='line' id='LC496'>				<span class="n">cal</span><span class="o">.</span><span class="na">leftSide</span> <span class="o">=</span> <span class="kc">true</span><span class="o">;</span></div><div class='line' id='LC497'>				<span class="n">setState</span><span class="o">(</span><span class="n">cState</span><span class="o">.</span><span class="na">LEFTBR</span><span class="o">);</span></div><div class='line' id='LC498'>			<span class="o">}</span></div><div class='line' id='LC499'>		<span class="o">}</span></div><div class='line' id='LC500'><br/></div><div class='line' id='LC501'>	<span class="o">}</span><span class="c1">// GEN-LAST:event_LRButtonMousePressed</span></div><div class='line' id='LC502'><br/></div><div class='line' id='LC503'>	<span class="cm">/**</span></div><div class='line' id='LC504'><span class="cm">	 * Draws on the map panel based on calibrated results</span></div><div class='line' id='LC505'><span class="cm">	 * </span></div><div class='line' id='LC506'><span class="cm">	 * @param x</span></div><div class='line' id='LC507'><span class="cm">	 * @param y</span></div><div class='line' id='LC508'><span class="cm">	 * @param lastX</span></div><div class='line' id='LC509'><span class="cm">	 * @param lastY</span></div><div class='line' id='LC510'><span class="cm">	 */</span></div><div class='line' id='LC511'>	<span class="kd">public</span> <span class="kd">static</span> <span class="kt">void</span> <span class="nf">drawCombine</span><span class="o">(</span><span class="kt">int</span> <span class="n">x</span><span class="o">,</span> <span class="kt">int</span> <span class="n">y</span><span class="o">,</span> <span class="kt">int</span> <span class="n">lastX</span><span class="o">,</span> <span class="kt">int</span> <span class="n">lastY</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC512'>		<span class="kt">int</span><span class="o">[]</span> <span class="n">adjust</span> <span class="o">=</span> <span class="n">cal</span><span class="o">.</span><span class="na">calculateOffsets</span><span class="o">(</span><span class="n">x</span><span class="o">,</span> <span class="n">y</span><span class="o">);</span></div><div class='line' id='LC513'>		<span class="kt">int</span><span class="o">[]</span> <span class="n">adjustLast</span> <span class="o">=</span> <span class="n">cal</span><span class="o">.</span><span class="na">calculateOffsets</span><span class="o">(</span><span class="n">lastX</span><span class="o">,</span> <span class="n">lastY</span><span class="o">);</span></div><div class='line' id='LC514'><br/></div><div class='line' id='LC515'>		<span class="o">((</span><span class="n">IRCombined</span><span class="o">)</span> <span class="n">irCombined</span><span class="o">).</span><span class="na">onIrEvent</span><span class="o">(</span><span class="n">adjust</span><span class="o">[</span><span class="mi">0</span><span class="o">],</span> <span class="n">adjust</span><span class="o">[</span><span class="mi">1</span><span class="o">],</span></div><div class='line' id='LC516'>				<span class="n">adjustLast</span><span class="o">[</span><span class="mi">0</span><span class="o">],</span> <span class="n">adjustLast</span><span class="o">[</span><span class="mi">1</span><span class="o">]);</span></div><div class='line' id='LC517'>	<span class="o">}</span></div><div class='line' id='LC518'><br/></div><div class='line' id='LC519'>	<span class="cm">/**</span></div><div class='line' id='LC520'><span class="cm">	 * Sets state of calibration ready for any re-calibrating,</span></div><div class='line' id='LC521'><span class="cm">	 * based on where the wiimotes are</span></div><div class='line' id='LC522'><span class="cm">	 * @param s</span></div><div class='line' id='LC523'><span class="cm">	 */</span></div><div class='line' id='LC524'>	<span class="kd">private</span> <span class="kt">void</span> <span class="nf">setState</span><span class="o">(</span><span class="n">cState</span> <span class="n">s</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC525'>		<span class="n">state</span> <span class="o">=</span> <span class="n">s</span><span class="o">;</span></div><div class='line' id='LC526'><br/></div><div class='line' id='LC527'>		<span class="k">if</span> <span class="o">(</span><span class="n">state</span> <span class="o">==</span> <span class="kc">null</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC528'>			<span class="k">if</span> <span class="o">(</span><span class="n">cal</span><span class="o">.</span><span class="na">leftSide</span> <span class="o">==</span> <span class="kc">true</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC529'>				<span class="n">setState</span><span class="o">(</span><span class="n">cState</span><span class="o">.</span><span class="na">LEFTBR</span><span class="o">);</span></div><div class='line' id='LC530'>			<span class="o">}</span> <span class="k">else</span> <span class="o">{</span></div><div class='line' id='LC531'>				<span class="n">setState</span><span class="o">(</span><span class="n">cState</span><span class="o">.</span><span class="na">RIGHTBL</span><span class="o">);</span></div><div class='line' id='LC532'>			<span class="o">}</span></div><div class='line' id='LC533'>		<span class="o">}</span></div><div class='line' id='LC534'>	<span class="o">}</span></div><div class='line' id='LC535'><br/></div><div class='line' id='LC536'>	<span class="cm">/**</span></div><div class='line' id='LC537'><span class="cm">	 * Debug function; should be removed from final product</span></div><div class='line' id='LC538'><span class="cm">	 */</span></div><div class='line' id='LC539'>	<span class="kd">public</span> <span class="kd">static</span> <span class="kt">void</span> <span class="nf">printCaliState</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC540'>		<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">&quot;isCalibrating state: &quot;</span> <span class="o">+</span> <span class="n">isCalibrating</span><span class="o">);</span></div><div class='line' id='LC541'>		<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">&quot;CaliButton state: &quot;</span> <span class="o">+</span> <span class="n">calibButton</span><span class="o">.</span><span class="na">isEnabled</span><span class="o">());</span></div><div class='line' id='LC542'>		<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">&quot;Order: &quot;</span> <span class="o">+</span> <span class="n">state</span><span class="o">.</span><span class="na">order</span><span class="o">);</span></div><div class='line' id='LC543'>		<span class="n">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">&quot;&quot;</span><span class="o">);</span></div><div class='line' id='LC544'>	<span class="o">}</span></div><div class='line' id='LC545'><br/></div><div class='line' id='LC546'><span class="o">}</span></div></pre></div></td>
          </tr>
        </table>
  </div>

  </div>
</div>

<a href="#jump-to-line" rel="facebox[.linejump]" data-hotkey="l" class="js-jump-to-line" style="display:none">Jump to Line</a>
<div id="jump-to-line" style="display:none">
  <form accept-charset="UTF-8" class="js-jump-to-line-form">
    <input class="linejump-input js-jump-to-line-field" type="text" placeholder="Jump to line&hellip;" autofocus>
    <button type="submit" class="button">Go</button>
  </form>
</div>

        </div>

      </div><!-- /.repo-container -->
      <div class="modal-backdrop"></div>
    </div><!-- /.container -->
  </div><!-- /.site -->


    </div><!-- /.wrapper -->

      <div class="container">
  <div class="site-footer">
    <ul class="site-footer-links right">
      <li><a href="https://status.github.com/">Status</a></li>
      <li><a href="http://developer.github.com">API</a></li>
      <li><a href="http://training.github.com">Training</a></li>
      <li><a href="http://shop.github.com">Shop</a></li>
      <li><a href="/blog">Blog</a></li>
      <li><a href="/about">About</a></li>

    </ul>

    <a href="/">
      <span class="mega-octicon octicon-mark-github" title="GitHub"></span>
    </a>

    <ul class="site-footer-links">
      <li>&copy; 2014 <span title="0.09885s from github-fe129-cp1-prd.iad.github.net">GitHub</span>, Inc.</li>
        <li><a href="/site/terms">Terms</a></li>
        <li><a href="/site/privacy">Privacy</a></li>
        <li><a href="/security">Security</a></li>
        <li><a href="/contact">Contact</a></li>
    </ul>
  </div><!-- /.site-footer -->
</div><!-- /.container -->


    <div class="fullscreen-overlay js-fullscreen-overlay" id="fullscreen_overlay">
  <div class="fullscreen-container js-fullscreen-container">
    <div class="textarea-wrap">
      <textarea name="fullscreen-contents" id="fullscreen-contents" class="js-fullscreen-contents" placeholder="" data-suggester="fullscreen_suggester"></textarea>
    </div>
  </div>
  <div class="fullscreen-sidebar">
    <a href="#" class="exit-fullscreen js-exit-fullscreen tooltipped tooltipped-w" aria-label="Exit Zen Mode">
      <span class="mega-octicon octicon-screen-normal"></span>
    </a>
    <a href="#" class="theme-switcher js-theme-switcher tooltipped tooltipped-w"
      aria-label="Switch themes">
      <span class="octicon octicon-color-mode"></span>
    </a>
  </div>
</div>



    <div id="ajax-error-message" class="flash flash-error">
      <span class="octicon octicon-alert"></span>
      <a href="#" class="octicon octicon-remove-close close js-ajax-error-dismiss"></a>
      Something went wrong with that request. Please try again.
    </div>

  </body>
</html>

