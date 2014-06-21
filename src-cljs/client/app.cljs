(ns client.app
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn widget [data owner]
  (reify
    om/IRender
    (render [this]
     (dom/h1 nil (:text data)))))

(om/root widget {:text "Hello, Om!"}
  {:target (. js/document (getElementById "app"))})
