(defproject cljs-showoff "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.908"]
                 [lein-asset-minifier "0.4.3"]
                 [reagent "0.7.0"]
                 [re-frame "0.10.1"]
                 [secretary "1.2.3"]
                 [garden "1.3.2"]
                 [ns-tracker "0.3.1"]
                 [compojure "1.6.0"]
                 [yogthos/config "0.9"]
                 [ring "1.6.2"]]

  :plugins [[lein-cljsbuild "1.1.5"]
            [lein-garden "0.2.8"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"
                                    "test/js"
                                    "resources/public/css/screen.css"]

  :figwheel {:css-dirs ["resources/public/css"]
             :ring-handler cljs-showoff.handler/dev-handler}

  :garden {:builds [{:id           "screen"
                     :source-paths ["src/clj"]
                     :stylesheet   cljs-showoff.css/screen
                     :compiler     {:output-to     "resources/public/css/screen.css"
                                    :pretty-print? true}}]}

  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

  :minify-assets [;; [:html {:source "dev/resource/html" :target "dev/minified/html"}]
                  [:css {:source "resources/public/css/ace.css" :target "resources/public/css/ace.min.css"}]
                  ;; [:js {:source ["dev/res/js1", "dev/res/js2"] :target "dev/minified/js/script.min.js"}]
                  ]

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.4"]
                   [figwheel-sidecar "0.5.13"]
                   [com.cemerick/piggieback "0.2.2"]]

    :plugins      [[lein-figwheel "0.5.13"]
                   [lein-doo "0.1.7"]]}}


  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "cljs-showoff.core/mount-root"}
     :compiler     {:main                 cljs-showoff.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true
                    :preloads             [devtools.preload]
                    :external-config      {:devtools/config {:features-to-install :all}}}}


    {:id           "min"
     :source-paths ["src/cljs"]
     :jar true
     :compiler     {:main            cljs-showoff.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}

    {:id           "test"
     :source-paths ["src/cljs" "test/cljs"]
     :compiler     {:main          cljs-showoff.runner
                    :output-to     "resources/public/js/compiled/test.js"
                    :output-dir    "resources/public/js/compiled/test/out"
                    :optimizations :none}}]}


  :main cljs-showoff.server

  :aot [cljs-showoff.server]

  :uberjar-name "cljs-showoff.jar"

  :prep-tasks [["cljsbuild" "once" "min"]["garden" "once"] "compile"])
