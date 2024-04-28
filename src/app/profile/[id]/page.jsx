// import { useEffect, useState } from "react";
import { posts, writer } from "@/utils/dummyData";
import Card from "@/components/other/Card";
import Button from "@/components/other/Button";

const WriterPage = ({ params }) => {
    // take user from local storage
    //   const { user } = useStore();
    const user = "hello";
    //   const { id } = params;
    //   const [writer, setWriter] = useState(null);

    //   const { posts, numOfPages, setPage } = usePosts({ writerId: id });
    //   const popular = usePopularPosts();

    //   const { userId } = useParams();
    //   const fetchWriterInfo = async () => {
    //     const res = await getWriterInfo(id);
    //     console.log(res);
    //     setWriter(res);
    //   };

    //   useEffect(() => {
    //     fetchWriterInfo();
    //   }, [id]);
    //   const handleFollow = async () => {
    //     const res = await followWriter(id, user?.token);
    //     if (res?.success === true) {
    //       fetchWriterInfo();
    //     }
    //   };

    if (!writer)
        return (
            <div className="w-full h-full py-8 flex items-center justify-center">
                <span className="text-lg text-slate-500">No Writer Found</span>
            </div>
        );
    return (
        <div className="px-0 2xl:px-20 ">
            <div className="w-full md:h-60 flex flex-col gap-5 items-center md:flex-row bg-black dark:bg-gradient-to-r from-[#020b19] via-[#071b3e] to-[#020b19]  mt-5 mb-10 rounded-md p-5 md:px-20">
                <img
                    src={writer?.image}
                    alt="Writer"
                    className="w-48 h-48 rounded-full border-4 border-slate-400 object-cover"
                />
                <div className="w-full h-full flex flex-col gap-y-5 md:gap-y-8  items-center justify-center">
                    <h2 className="text-white text-4xl 2xl:text-5xl font-bold">
                        {writer?.name}
                    </h2>
                    <div className="flex gap-10">
                        <div className="flex flex-col items-center">
                            <p className="text-gray-300 text-2xl font-semibold">
                                {writer?.followers.length}
                            </p>
                            <span className="text-gray-500">Followers</span>
                        </div>
                        <div className="flex flex-col items-center">
                            <p className="text-gray-300 text-2xl font-semibold">
                                {posts?.length}
                            </p>
                            <span className="text-gray-500">Posts</span>
                        </div>
                    </div>

                    {user && (
                        <div>
                            {user ? (
                                <Button
                                    label="Follow"
                                    styles="text-slate-800 text-semibold md:-mt-4 px-6 py-1 rounded-full bg-white"
                                />
                            ) : (
                                <div className="flex items-center justify-center gap-2 text-white text-semibold md:-mt-4 px-6 py-1 rounded-full border">
                                    <span>Following</span>
                                    {/* <FaUserCheck /> */}
                                </div>
                            )}
                        </div>
                    )}
                </div>
            </div>

            <div className="w-full flex flex-col md:flex-row gap-10 2xl:gap-20">
                <div className="w-full md:w-full flex flex-col gap-y-28 md:gap-y-14">
                    {posts?.length === 0 ? (
                        <div className="w-full h-full py-8 flex  justify-center">
                            <span className="text-lg text-slate-500">
                                No Post Available
                            </span>
                        </div>
                    ) : (
                        <>
                            {posts?.map((post, index) => (
                                <Card key={post?._id} post={post} />
                            ))}
                        </>
                    )}
                </div>
            </div>
        </div>
    );
};

export default WriterPage;
