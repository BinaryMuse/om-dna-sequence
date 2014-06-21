(ns server.handler
  (:require [ring.middleware.reload :as reload]
            [ring.util.response :as response]
            [compojure.core :refer :all]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [org.httpkit.server :refer [run-server]]))

(defroutes all-routes
  (GET "/" []
       (response/file-response
        "index.html"
        {:root "resources/public"}))

  (route/resources "/" {:root "public"})
  (route/not-found "<p>Not found.</p>"))

(defonce server
  (atom nil))

(def handler
  (-> (site all-routes)
      reload/wrap-reload))

(defn start-server []
  (println "Starting server...")
  (reset! server (run-server #'handler {:port 8080}))
  (println "Server up on port 8080"))

(defn stop-server []
  (when-not (nil? @server)
    (println "Stopping")
    (@server :timeout 100)
    (reset! server nil)))

(defn -main [& args]
  (start-server)
  (.addShutdownHook
   (Runtime/getRuntime)
   (Thread. #(stop-server))))
