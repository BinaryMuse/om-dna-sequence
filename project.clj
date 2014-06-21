(defproject dna-sequence "0.0.1"
  :description "Om port of https://github.com/davejacobs/cljs-example"
  :url "https://github.com/BinaryMuse/om-dna-sequence"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2234"]
                 [om "0.6.4"]
                 [http-kit/http-kit "2.1.16"]
                 [compojure/compojure "1.1.5"]
                 [org.clojure/core.async "0.1.303.0-886421-alpha"]
                 [ring/ring-devel "1.1.8"]
                 [ring/ring-json "0.3.1"]]

  :plugins [[lein-cljsbuild "1.0.3"]]

  :aliases {"serve" ["run" "-m" "server.handler"]}

  :source-paths ["src" "src-cljs"]
  :resource-paths ["resources"]

  :cljsbuild
  {:builds
   [{:source-paths ["src-cljs"]
     :compiler
     {:output-to "resources/public/javascripts/lib.js"
      :output-dir "resources/public/javascripts"
      :optimizations :none
      :source-map true}}]})
