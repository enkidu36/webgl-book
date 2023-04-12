(ns pbranes.math-notebook.app
  (:require [goog.dom :as gdom]
            ["react-dom/client" :as rdom]
            ["react-router-dom" :as rr]
            [helix.core :refer [defnc $]]
            [helix.dom :as d]))

(defnc home []
  (d/div "Hello Dolly !!!"))

(defnc layout []
  (d/div {:class "wrapper"}
         (d/header {:class "header"}
                   (d/nav {:class "nav"}
                          ($ rr/Link {:to "/"} "Home")))
         (d/div {:class "main"} ($ rr/Outlet))
         (d/div {:class "footer"} "footer")))

(defnc router []
  ($ rr/Routes
     ($ rr/Route {:path "/" :element ($ layout)}
        ($ rr/Route {:path "/" :element ($ home)}))))


(defnc app []
  ($ rr/BrowserRouter
     ($ router)))

(defonce root (rdom/createRoot (gdom/getElement "root")))

(defn ^:dev/after-load init! []
  (.render root ($ app)))

(init!)