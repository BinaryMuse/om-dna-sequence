(defproject dna-sequence "0.0.1"
  :description "Om port of https://github.com/davejacobs/cljs-example"
  :url "https://github.com/BinaryMuse/om-dna-sequence"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2234"]
                 [om "0.6.4"]]

  :plugins [[lein-cljsbuild "1.0.3"]]

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
