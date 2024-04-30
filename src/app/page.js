"use client";
import Blog from "@/components/Blog";
import Navbar from "@/components/Navbar";
import axios from "axios";
import { useEffect, useState } from "react";

export default function Home() {
    const [blogs, setBlogs] = useState([]);
    const [loading, setLoading] = useState(false);

    const getBlogs = async () => {
        setLoading(true);
        try {
            const res = await axios.get("/api/getallposts");
            // Access data directly from the response
            console.log(res.data.data.data)
            if (res.data.data.data.length > 0) {
                setBlogs(res.data.data.data);
                setLoading(false);
            } else {
                console.log("No data found");
            }
        } catch (error) {
            console.error("Error fetching blogs:", error);
            setLoading(false);
        }
    };

    useEffect(() => {
        getBlogs();
    }, []);

    return (
        <>
        <Navbar />    
        <main className="flex gap-12 flex-wrap p-10">
            {loading ? (
                <p>Loading...</p>
            ) : (
                blogs?.map((blog, index) => <Blog key={index} blog={blog} />)
            )}
        </main>
    </>
    );
}
