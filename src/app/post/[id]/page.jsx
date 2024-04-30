"use client";
// import Markdown from "markdown-to-jsx";
import { useEffect, useState } from "react";
import Markdown from "markdown-to-jsx";
import { posts, popular } from "@/utils/dummyData.js";

import Link from "next/link";
import PopularPosts from "@/components/other/PopularPosts";
import Carosal from "@/components/other/Carosal";
import PostComments from "@/components/other/PostComments";
import axios from "axios";
import Image from "next/image";
import profilePic from "/public/user.png";
import PostSkeliton from "@/components/PostSkeliton";

const Pages = ({ params }) => {
    const [popularPost, setPopularPost] = useState(popular);
    const [backEndUrl, serBackEndUrl] = useState("");
    const [loading, setLoading] = useState(false);

    const { id } = params;

    const [post, setPost] = useState(null);
    const [date, setDate] = useState(null);

    const getPost = async () => {
        setLoading(true);
        const data = {
            postId: id,
        };
        const url = await axios.get("/api/backendurl");
        serBackEndUrl(url.data.data);
        const res = await axios.post("/api/getpostbyid", data);
        console.log(res.data.data);
        setPost(res.data.data);
        // Extract date-time components
        const [year, month, day, hours, minutes, seconds, milliseconds] =
            res.data.data.postCreationTime;

        // Create a JavaScript Date object
        const date = new Date(
            year,
            month - 1,
            day,
            hours,
            minutes,
            seconds,
            milliseconds
        );
        setDate(date.toLocaleString());
        setLoading(false);
    };

    useEffect(() => {
        getPost();
    }, []);

    return (
        <>
            {loading ? (
                <PostSkeliton />
            ) : (
                <div className="w-full  px-0 md:px-4 py-6 2xl:px-10">
                    <div className="w-full flex flex-col-reverse md:flex-row gap-2 gap-y-5 items-center">
                        <img
                            src={backEndUrl + post?.postImagePath}
                            alt={post?.postTitle}
                            className="w-full md:w-full h-64 md:h-[460px] 2xl:h-[580px] rounded "
                        />
                    </div>
                    <div className="w-full flex flex-col md:flex-row gap-10 2xl:gap-x-28 mt-8">
                        <Link
                            href={`/profile/${post?.createdBy?.userId}`}
                            className="w-3/4 flex  md:flex-row gap-6 2xl:gap-x-14 mt-6"
                        >
                            <Image
                                src={profilePic}
                                alt={profilePic}
                                className="w-8 h-8 rounded-full"
                            />
                            <h1 className="text-xl md:text-3xl font-bold text-slate-800 dark:text-white">
                                {post?.createdBy?.name}
                            </h1>
                        </Link>
                        <span className="text-slate-700 text-xl w-1/4  flex justify-center items-center italic">
                            {date}
                        </span>
                    </div>

                    <div className="w-full flex flex-col md:flex-row gap-10 2xl:gap-x-28 mt-8">
                        <h1 className="text-3xl md:text-5xl font-bold text-slate-800 dark:text-white">
                            {post?.postTitle}
                        </h1>
                    </div>

                    <div className="w-full flex flex-col md:flex-row gap-8 2xl:gap-x-28 mt-8">
                        {/* LEFT */}
                        <div className="w-full  flex flex-col text-black dark:text-gray-500 ">
                            {post?.postContent && (
                                <Markdown
                                    options={{ wrapper: "article" }}
                                    className="leading-[1.5rem] text-base 2xl:text-[20px]"
                                >
                                    {post?.postContent}
                                </Markdown>
                            )}
                        </div>

                        {/* RIGHT */}
                        {/* <div className="w-full md:w-1/4 flex flex-col gap-y-12">
          <PopularPosts posts={popular?.posts} category={post?.cat} />
        </div> */}
                    </div>

                    {/* COMMENTS SECTION */}
                    <div className="w-full">
                        {post && (
                            <PostComments postId={post?.comments} id={id} />
                        )}
                    </div>
                </div>
            )}
        </>
    );
};

export default Pages;
