(ns cljs-showoff.css
  (:require [garden.def :refer [defstyles]]))

(defstyles screen
  [:body {:color "black"
          :font-family "'Crimson Text'"
          :font-size "1.2em"
          :text-align "center"
          :line-height "1.6"}]
  [:a {:color "#1565c0"}]
  [:h1 {:font-family "'Encode Sans'"
        :font-size "3em"
        ;; :text-align "center"
        ;; :color "#FF3692"
        }]
  [:h2 {:font-family "'Montserrat Subrayada'"}]
  [:h3 {:font-family "'Montserrat Subrayada'"}]
  [:h4 {:font-family "'Montserrat Subrayada'"}]
  [:h5 {:font-family "'Montserrat Subrayada'"}]
  [:h6 {:font-family "'Montserrat Subrayada'"}]
)
